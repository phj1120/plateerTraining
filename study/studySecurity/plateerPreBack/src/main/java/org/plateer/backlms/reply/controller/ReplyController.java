package org.plateer.backlms.reply.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.backlms.reply.dto.ReplyListDTO;
import org.plateer.backlms.reply.service.ReplyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/api/reply/")
@RequiredArgsConstructor
@Log4j2
public class ReplyController {
    private final ReplyService replyService;


    /*
     2022.01.24 박현준 / 롤링페이퍼 목록 호출
    */
    @GetMapping("{id}")
    public ReplyListDTO getReplyList(@PathVariable("id") Long id) {
        return replyService.getReplyList(id);
    }
}
