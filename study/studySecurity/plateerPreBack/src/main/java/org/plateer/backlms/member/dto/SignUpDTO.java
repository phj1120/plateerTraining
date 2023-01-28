package org.plateer.backlms.member.dto;

import lombok.Data;

@Data
public class SignUpDTO {
    private String memberId;
    private String memberName;
    private String password;
}
