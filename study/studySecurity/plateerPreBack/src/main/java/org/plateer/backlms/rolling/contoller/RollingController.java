package org.plateer.backlms.rolling.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.backlms.common.dto.PageReqDTO;
import org.plateer.backlms.common.dto.PageResultDTO;
import org.plateer.backlms.rolling.dto.RollingDTO;
import org.plateer.backlms.rolling.dto.RollingSearchDTO;
import org.plateer.backlms.rolling.service.RollingService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/rolling/")
@RequiredArgsConstructor
@Log4j2
public class RollingController {
    private final RollingService rollingService;


    /*
        2023.01.24 정승현 / 롤링페이퍼 호출 ( Home Page 메뉴에 사용 )
     */
    @GetMapping("getRollingAllList")
    public List<RollingDTO> getRollingAllList() {
        return rollingService.getRollingAllList();
    }


    /*
        2023.01.24 정승현 / 페이징으로 롤링페이퍼 호출 ( Rollingpaper List 메뉴에 사용 )
     */
    @GetMapping("getRollingList")
    public PageResultDTO<RollingDTO> getRollingList(PageReqDTO pageReqDTO) {
        return rollingService.getRollingList(pageReqDTO);
    }


    /*
        2023.01.25 이수영 / 롤링페이퍼 추가 ( Rollingpaper Add 메뉴에 사용 )
     */
    @PostMapping("postRollingPaper")
    public Long addPost(@Validated @RequestBody RollingDTO rollingDTO) {
        return rollingService.addPaper(rollingDTO);
    }


    /*
        2023.01.25 정승현 / 롤링페이퍼 추가 시 첨부파일 저장 ( Rollingpaper Add 메뉴에 사용 )
     */
    @PostMapping("postRollingFile")
    public String postRollingFile(@RequestParam("filelist") List<MultipartFile> files) throws IOException {
        if (!files.isEmpty()) {
            for (MultipartFile file : files) {
                String fullPath = "D:/" + file.getOriginalFilename();
//            String fullPath = "Z:/pre_project/" + file.getOriginalFilename();
                file.transferTo(new File(fullPath));
            }
        }

        return "test-form";
    }


    /*
        2023.01.25 정승현 / 검색으로 롤링페이퍼 호출 ( Rollingpaper List 메뉴에서 사용 )
     */
    @GetMapping("getSearchRollingList")
    public PageResultDTO<RollingDTO> getSearchRollingList(PageReqDTO pageReqDTO, RollingSearchDTO rollingSearchDTO) {
        return rollingService.getSearchRollingList(pageReqDTO, rollingSearchDTO);
    }
}
