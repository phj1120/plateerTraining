package org.plateer.backlms.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.plateer.backlms.member.entity.Member;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long id;
    private String memberId;
    private String password;
    private String memberName;
    private MemberRole memberRole;
    private LocalDate createDt;
    private LocalDate updateDt;

    public MemberDTO(Member member) {
        this.id = member.getId();
        this.memberId = member.getMemberId();
        this.password = member.getPassword();
        this.memberName = member.getMemberName();
        this.memberRole = member.getMemberRole();
        this.createDt = member.getCreateDt();
        this.updateDt = member.getUpdateDt();
    }
}
