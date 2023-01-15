package today.parkh.v0115.product.domain;

import lombok.*;
import today.parkh.v0115.common.domain.BaseEntity;
import today.parkh.v0115.user.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "tbl_reply")
@EqualsAndHashCode(of = "rno", callSuper = true)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review extends BaseEntity {

    @Id
    @GeneratedValue
    private Long rno;

    @ManyToOne
    private Product product;

    @OneToOne
    private User reviewer;
}
