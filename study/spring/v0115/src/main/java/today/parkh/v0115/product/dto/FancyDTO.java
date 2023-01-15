package today.parkh.v0115.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import today.parkh.v0115.product.domain.Product;
import today.parkh.v0115.user.domain.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FancyDTO {
    private Long fno;
    private Product product;
    private User fancyUser;

    public FancyDTO(Product product, User fancyUser) {
        this.product = product;
        this.fancyUser = fancyUser;
    }
}
