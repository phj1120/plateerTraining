package org.plateer.backlms.member.entity;

import lombok.*;
import org.plateer.backlms.member.dto.MemberRole;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_member")
@EqualsAndHashCode(callSuper = false, of = "id")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String memberId;
    private String password;
    private String memberName;

    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    private LocalDate createDt;
    private LocalDate updateDt;

    public Member(String memberId, String password, String memberName) {
        this.memberId = memberId;
        this.password = password;
        this.memberName = memberName;
        this.memberRole = MemberRole.ROLE_USER;
        this.createDt = LocalDate.now();
    }

    public Member(String memberId, String password, String memberName, MemberRole memberRole) {
        this.memberId = memberId;
        this.password = password;
        this.memberName = memberName;
        this.memberRole = memberRole;
        this.createDt = LocalDate.now();
    }


}
