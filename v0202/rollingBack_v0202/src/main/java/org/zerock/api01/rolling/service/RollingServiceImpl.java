package org.zerock.api01.rolling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.api01.common.dto.PageResultDTO;
import org.zerock.api01.common.image.ImageService;
import org.zerock.api01.common.image.dto.SaveResult;
import org.zerock.api01.rolling.dto.*;
import org.zerock.api01.rolling.mapper.RollingMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class RollingServiceImpl implements RollingService {
    private final RollingMapper rollingMapper;
    private final ImageService imageService;

    @Override
    public PageResultDTO<RollingInfoDTO> getList(RollingPageRequestDTO rollingPageRequestDTO) {
        List<RollingInfoDTO> dtoList = rollingMapper.getList(rollingPageRequestDTO).stream()
                .map(rollingDTO -> new RollingInfoDTO(rollingDTO))
                .collect(Collectors.toList());
        int total = rollingMapper.getCount(rollingPageRequestDTO);

        PageResultDTO<RollingInfoDTO> pageResponseDTO = PageResultDTO.<RollingInfoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(rollingPageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    @Override
    public RollingDetailDTO getRolling(Long id) {
        RollingDTO rollingDTO = rollingMapper.getRolling(id);
        if (rollingDTO == null) {
            throw new IllegalArgumentException("조회 실패");
        }
        List<String> imagePaths = imageService.getImagePaths(rollingDTO.getRollingId());

        return new RollingDetailDTO(rollingDTO, imagePaths);
    }

    @Override
    public RollingInfoDTO addRolling(AddRollingDTO addRollingDTO) {
        RollingDTO rollingDTO;
        if (addRollingDTO.getImages().isEmpty()) {
            rollingDTO = addRollingDTO.convert();
            int count = rollingMapper.addRolling(rollingDTO);
            if (count != 1) {
                throw new IllegalArgumentException("추가 실패");
            }

            return new RollingInfoDTO(rollingDTO);
        }

        // 사진 저장
        List<MultipartFile> images = addRollingDTO.getImages();
        SaveResult saveResult = imageService.saveImages(images);

        // 썸네일 포함해 저장
        String thumbnailPath = "s_" + saveResult.getPath(addRollingDTO.getThumbnailIndex());
        rollingDTO = addRollingDTO.convert(thumbnailPath);
        int count = rollingMapper.addRolling(rollingDTO);
        if (count != 1) {
            throw new IllegalArgumentException("추가 실패");
        }

        // 사진 DB 에 게시글 외래키로 추가
        List<String> paths = saveResult.getPaths();
        imageService.setRollingId(rollingDTO.getRollingId(), paths);

        return new RollingInfoDTO(rollingDTO);
    }

    @Override
    public RollingInfoDTO modifyRolling(ModifyRollingDTO modifyRollingDTO) {
        // 기존 사진 삭제
        imageService.deleteImageByRollingId(modifyRollingDTO.getId());

        // 사진이 없는 경우 사진 저장 하지 않고 바로 수정
        RollingDTO rollingDTO;
        if (modifyRollingDTO.getImages().isEmpty()) {
            rollingDTO = modifyRollingDTO.convert();
            int count = rollingMapper.modifyRolling(rollingDTO);
            if (count != 1) {
                throw new IllegalArgumentException("추가 실패");
            }

            return new RollingInfoDTO(rollingDTO);
        }

        // 받아온 사진 저장
        List<MultipartFile> images = modifyRollingDTO.getImages();
        SaveResult saveResult = imageService.saveImages(images);

        // 썸네일 포함해 저장
        String thumbnailPath = "s_" + saveResult.getPath(modifyRollingDTO.getThumbnailIndex());
        rollingDTO = modifyRollingDTO.convert(thumbnailPath);
        int count = rollingMapper.modifyRolling(rollingDTO);
        if (count != 1) {
            throw new IllegalArgumentException("추가 실패");
        }

        // 저장된 사진 외래키 업데이트
        List<String> paths = saveResult.getPaths();
        imageService.setRollingId(rollingDTO.getRollingId(), paths);

        return new RollingInfoDTO(rollingDTO);
    }

    @Override
    public void deleteRolling(Long rollingId) {
        int count = rollingMapper.deleteRolling(rollingId);
        imageService.deleteImageByRollingId(rollingId);

        if (count != 1) {
            throw new IllegalArgumentException("삭제 실패");
        }
    }
}
