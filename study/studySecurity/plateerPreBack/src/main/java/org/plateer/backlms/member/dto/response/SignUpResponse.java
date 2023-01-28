package org.plateer.backlms.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.plateer.backlms.member.dto.MemberDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpResponse {
    private Long memberNo;

    public SignUpResponse(MemberDTO memberDTO) {
        this.memberNo = memberDTO.getId();
    }
}
