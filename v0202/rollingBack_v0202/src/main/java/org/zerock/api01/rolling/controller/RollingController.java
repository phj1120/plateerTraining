package org.zerock.api01.rolling.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.zerock.api01.common.dto.PageResultDTO;
import org.zerock.api01.common.dto.ResultDTO;
import org.zerock.api01.rolling.dto.*;
import org.zerock.api01.rolling.service.RollingService;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("api/rollings")
public class RollingController {
    private final RollingService rollingService;

    @GetMapping("list")
    public PageResultDTO<RollingInfoDTO> getList(RollingPageRequestDTO rollingPageRequestDTO) {

        return rollingService.getList(rollingPageRequestDTO);
    }

    @GetMapping("{id}")
    public ResultDTO<RollingDetailDTO> getRolling(@PathVariable("id") Long id) {
        RollingDetailDTO rollingDetailDTO = rollingService.getRolling(id);

        return ResultDTO.<RollingDetailDTO>builder().data(rollingDetailDTO).build();
    }

    // 추가
    @PostMapping
    public ResultDTO<AddRollingResponse> addRolling(@ModelAttribute AddRollingRequest request) {
        AddRollingDTO addRollingDTO = new AddRollingDTO(request);
        RollingInfoDTO rollingInfoDTO = rollingService.addRolling(addRollingDTO);

        return ResultDTO.<AddRollingResponse>builder().data(new AddRollingResponse(rollingInfoDTO)).build();
    }

    // 수정
    @PutMapping("{rollingId}")
    public ResultDTO<ModifyRollingDTO> modifyRolling(@PathVariable("rollingId") Long id,
                                                     @RequestBody ModifyRollingRequest request) {
        ModifyRollingDTO modifyRollingDTO = new ModifyRollingDTO(id, request);
        rollingService.modifyRolling(modifyRollingDTO);

        return ResultDTO.<ModifyRollingDTO>builder().data(modifyRollingDTO).build();
    }

    // 삭제
    @DeleteMapping("{rollingId}")
    public ResultDTO<Long> deleteRolling(@PathVariable("rollingId") Long id) {
        rollingService.deleteRolling(id);

        return ResultDTO.<Long>builder().data(id).build();
    }
}
