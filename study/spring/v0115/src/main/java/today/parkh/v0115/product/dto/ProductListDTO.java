package today.parkh.v0115.product.dto;

import lombok.Data;
import today.parkh.v0115.product.domain.Product;
import today.parkh.v0115.user.domain.User;

@Data
public class ProductListDTO {
    private Long pno;
    private String productName;
    private int price;
    private String sellerName;
    private Long fancyCount;
    private Long reviewCount;

    public ProductListDTO(Product product, User user, Long fancyCount, Long reviewCount) {
        this.pno = product.getPno();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.sellerName = user.getName();
        this.fancyCount = fancyCount;
        this.reviewCount = reviewCount;
    }
}
