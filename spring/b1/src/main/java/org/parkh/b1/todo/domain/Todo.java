package org.parkh.b1.todo.domain;

import lombok.*;
import org.parkh.b1.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_todo") // DB 안 꼬이게 하려면 이게 낫더라...
@EqualsAndHashCode(of = "id", callSuper = false)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tno")
    public Long id;

    private String title;

    private String writer;
}
