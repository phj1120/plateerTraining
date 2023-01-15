package today.parkh.v0115.product.domain;

import lombok.*;
import today.parkh.v0115.common.domain.BaseEntity;
import today.parkh.v0115.product.dto.ReviewDTO;
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

    private String title;

    private String content;

    @ManyToOne
    private Product product;

    @OneToOne
    private User reviewer;

    public Review(ReviewDTO dto, Product product, User reviewer) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.product = product;
        this.reviewer = reviewer;
    }
}
