package org.zerock.api01.rolling.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.zerock.api01.common.dto.PageRequestDTO;
import org.zerock.api01.common.dto.PageResultDTO;
import org.zerock.api01.common.dto.ResultDTO;
import org.zerock.api01.rolling.dto.AddRollingRequest;
import org.zerock.api01.rolling.dto.ModifyRollingRequest;
import org.zerock.api01.rolling.dto.RollingDTO;
import org.zerock.api01.rolling.dto.RollingPageRequestDTO;
import org.zerock.api01.rolling.service.RollingService;
import org.zerock.api01.rolling.vo.RollingVO;

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
    public ResultDTO<RollingVO> getRolling(@PathVariable("id") Long id) {
        RollingDTO rollingDTO = rollingService.getRolling(id);

        return ResultDTO.<RollingVO>builder().data(new RollingVO(rollingDTO)).build();
    }

    // 추가
    @PostMapping
    public ResultDTO<RollingVO> addRolling(@RequestBody AddRollingRequest request) {
        RollingDTO rollingDTO = request.convert();
        rollingService.addRolling(rollingDTO);

        return ResultDTO.<RollingVO>builder().data(new RollingVO(rollingDTO)).build();
    }

    // 수정
    @PutMapping("{rollingId}")
    public ResultDTO<RollingVO> modifyRolling(@PathVariable("rollingId") Long id, @RequestBody ModifyRollingRequest request) {
        RollingDTO rollingDTO = request.convert(id);
        rollingService.modifyRolling(rollingDTO);

        return ResultDTO.<RollingVO>builder().data(new RollingVO(rollingDTO)).build();
    }

    // 삭제
    @DeleteMapping("{rollingId}")
    public ResultDTO<Long> deleteRolling(@PathVariable("rollingId") Long id) {
        rollingService.deleteRolling(id);

        return ResultDTO.<Long>builder().data(id).build();
    }
}
