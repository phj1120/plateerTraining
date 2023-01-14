package org.parkh.b1.product.domain;

import lombok.*;
import org.parkh.b1.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_product") // DB 안 꼬이게 하려면 이게 낫더라...
@EqualsAndHashCode(of = "pno", callSuper = false)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    private String productName;

    private int price;

}
