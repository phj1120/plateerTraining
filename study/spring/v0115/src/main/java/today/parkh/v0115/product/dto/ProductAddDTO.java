package today.parkh.v0115.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddDTO {
    private String productName;
    private int price;
    private long sellerId;
}
