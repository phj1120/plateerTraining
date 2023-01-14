package org.parkh.b1.product.domain;


import lombok.*;
import org.parkh.b1.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_review") // DB 안 꼬이게 하려면 이게 낫더라...
@EqualsAndHashCode(of = "rno", callSuper = false)
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
