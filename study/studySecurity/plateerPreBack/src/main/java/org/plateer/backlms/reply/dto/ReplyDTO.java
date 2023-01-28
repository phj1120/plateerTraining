package org.plateer.backlms.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.plateer.backlms.reply.domain.Reply;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    private Long id;
    private String title;
    private String writer;

    public ReplyDTO(Reply reply) {
        this.id = reply.getId();
        this.title = reply.getTitle();
        this.writer = reply.getWriter().getMemberName();
    }
}
