package today.parkh.v0115.product.domain;

import lombok.*;
import today.parkh.v0115.common.domain.BaseEntity;
import today.parkh.v0115.product.dto.FancyDTO;
import today.parkh.v0115.user.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fancy")
@EqualsAndHashCode(of = "fno", callSuper = true)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fancy extends BaseEntity {

    @Id
    @GeneratedValue
    private Long fno;

    @ManyToOne
    private Product product;

    @OneToOne
    private User fancyUser;

    public Fancy(FancyDTO dto, Product product, User fancyUser) {
        this.product = product;
        this.fancyUser = fancyUser;
    }
}
