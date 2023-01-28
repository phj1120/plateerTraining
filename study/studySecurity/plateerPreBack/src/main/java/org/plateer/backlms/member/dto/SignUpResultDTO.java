package org.plateer.backlms.member.dto;

import lombok.Data;
import org.plateer.backlms.member.entity.Member;

@Data
public class SignUpResultDTO {
    private Long memberNo;

    public SignUpResultDTO(Member member) {
        this.memberNo = member.getId();
    }
}
