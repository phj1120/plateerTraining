package org.plateer.backlms.rolling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.plateer.backlms.common.dto.PageRequestDTO;
import org.plateer.backlms.common.dto.PageResultDTO;
import org.plateer.backlms.rolling.domain.Rolling;
import org.plateer.backlms.rolling.dto.RollingDTO;
import org.plateer.backlms.rolling.dto.RollingSearchDTO;
import org.plateer.backlms.rolling.repository.RollingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class RollingServiceImpl implements RollingService {
    private final ModelMapper modelMapper;
    private final RollingRepository rollingRepository;


//    @Override
//    public List<RollingDTO> getRollingAllList() {
//        List<Rolling> rolling = rollingRepository.findAll();
//        List<RollingDTO> list = rolling.stream().map(arr -> {
//            RollingDTO rollingDTO = modelMapper.map(arr, RollingDTO.class);
//            return rollingDTO;
//        }).collect(Collectors.toList());
//
//        return list;
//    }

    @Override
    public Long addPaper(RollingDTO rollingDTO) {
        Rolling rolling = modelMapper.map(rollingDTO, Rolling.class);
        Long id = rollingRepository.save(rolling).getId();

        return id;
    }

    @Override
    public PageResultDTO<RollingDTO> getRollingList(PageRequestDTO pageRequestDTO, RollingSearchDTO rollingSearchDTO) {
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("id").descending());

        Page<RollingDTO> rollingDTOPage = rollingRepository.searchList(pageable, rollingSearchDTO);

        PageResultDTO<RollingDTO> pageResultDTO = new PageResultDTO<>(rollingDTOPage, pageable);

        return pageResultDTO;
    }

    @Override
    public RollingDTO getRolling(Long id) {
        Rolling rolling = rollingRepository.findById(id).orElseThrow();

        return RollingDTO.builder()
                .id(rolling.getId())
                .title(rolling.getTitle())
                .writer(rolling.getWriter())
                .target(rolling.getTarget())
                .imgSrc(rolling.getImgSrc())
                .build();
    }

}
