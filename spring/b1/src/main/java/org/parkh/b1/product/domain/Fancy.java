package org.parkh.b1.product.domain;

import lombok.*;
import org.parkh.b1.common.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fancy") // DB 안 꼬이게 하려면 이게 낫더라...
@EqualsAndHashCode(of = "fno", callSuper = false)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fancy extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;

    @ManyToOne
    private Product product;

    private String fancyWriter;

}
