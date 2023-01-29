package org.plateer.backlms.reply.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ReplyListDTO {
    private String targetName;
    private List<ReplyDTO> replyDTOs = new ArrayList<>();

    public ReplyListDTO(String targetName, List<ReplyDTO> replyDTOs) {
        this.targetName = targetName;
        this.replyDTOs = replyDTOs;
    }
}
