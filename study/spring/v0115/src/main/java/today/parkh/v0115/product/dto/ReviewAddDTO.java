package today.parkh.v0115.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewAddDTO {
    private Long rno;
    private String title;
    private String content;
    private Long productId;
    private Long reviewerId;

    public ReviewAddDTO(String title, String content, Long productId, Long reviewerId) {
        this.title = title;
        this.content = content;
        this.productId = productId;
        this.reviewerId = reviewerId;
    }
}
