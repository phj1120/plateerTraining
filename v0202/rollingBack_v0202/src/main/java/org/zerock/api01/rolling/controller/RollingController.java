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
    public PageResultDTO<RollingDTO> getList(RollingPageRequestDTO rollingPageRequestDTO) {

        return rollingService.getList(rollingPageRequestDTO);
    }

    @GetMapping("{id}")
    public ResultDTO<RollingDTO> getRolling(@PathVariable("id") Long id) {
        RollingDTO rollingDTO = rollingService.getRolling(id);

        return ResultDTO.<RollingDTO>builder().data(rollingDTO).build();
    }

    // 추가
    @PostMapping
    public ResultDTO<AddRollingDTO> addRolling(@RequestBody AddRollingRequest request) {
        AddRollingDTO addRollingDTO = new AddRollingDTO(request);
        rollingService.addRolling(addRollingDTO);

        return ResultDTO.<AddRollingDTO>builder().data(addRollingDTO).build();
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
