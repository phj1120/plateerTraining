package today.parkh.v0115.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FancyAddDTO {
    private Long productId;
    private Long fancyUserId;

}
