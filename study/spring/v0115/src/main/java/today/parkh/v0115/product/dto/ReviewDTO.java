package today.parkh.v0115.product.dto;

import lombok.Data;
import today.parkh.v0115.product.domain.Product;
import today.parkh.v0115.user.domain.User;

@Data
public class ReviewDTO {
    private Long rno;
    private String title;
    private String content;
    private Product product;
    private User reviewer;
}
