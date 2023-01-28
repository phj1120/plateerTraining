package org.plateer.backlms.reply.domain;

import lombok.*;
import org.plateer.backlms.member.entity.Member;
import org.plateer.backlms.rolling.domain.Rolling;

import javax.persistence.*;

@Entity
@Table(name = "tbl_reply")
@EqualsAndHashCode(callSuper = false, of = "id")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @OneToOne
    private Member writer;

    @ManyToOne
    private Rolling rolling;
}
