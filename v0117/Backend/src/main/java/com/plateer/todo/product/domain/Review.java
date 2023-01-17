package com.plateer.todo.product.domain;

import com.plateer.todo.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_review")
@EqualsAndHashCode(callSuper=false, of="rno")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne
    private Product product;

    private String text;

}
