package org.plateer.backlms.reply.service;

import org.plateer.backlms.reply.dto.ReplyListDTO;

public interface ReplyService {

    ReplyListDTO getReplyList(Long rollingId);
}
