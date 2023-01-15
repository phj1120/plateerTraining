package today.parkh.v0115.product.dto;

import lombok.Data;
import today.parkh.v0115.user.domain.User;

@Data
public class ProductDTO {
    private Long pno;
    private String productName;
    private int price;
    private User seller;
}
