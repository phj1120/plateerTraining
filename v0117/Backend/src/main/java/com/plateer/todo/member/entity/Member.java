package com.plateer.todo.member.entity;

import com.plateer.todo.common.domain.BaseEntity;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
@Table(name = "tbl_member")
@EqualsAndHashCode(callSuper = false, of = "id")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
}
