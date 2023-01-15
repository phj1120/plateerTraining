package today.parkh.v0115.product.domain;

import lombok.*;
import today.parkh.v0115.common.domain.BaseEntity;
import today.parkh.v0115.user.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "tbl_product")
@EqualsAndHashCode(of = "pno", callSuper = true)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product extends BaseEntity {

    @Id
    @GeneratedValue
    private Long pno;

    private String productName;

    private int price;

    @ManyToOne
    private User seller;


}
