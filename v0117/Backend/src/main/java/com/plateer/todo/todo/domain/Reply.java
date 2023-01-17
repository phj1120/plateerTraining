package com.plateer.todo.todo.domain;

import lombok.*;
import com.plateer.todo.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_todo_reply")
@EqualsAndHashCode(callSuper=false, of="rno")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne
    private Todo todo;


}
