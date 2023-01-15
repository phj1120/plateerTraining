package today.parkh.v0115.product.service;

import today.parkh.v0115.product.dto.ProductDTO;
import today.parkh.v0115.product.dto.ReviewAddDTO;
import today.parkh.v0115.product.dto.ReviewDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ReviewService {
    ReviewDTO addReview(ReviewAddDTO dto);

    List<ReviewDTO> reviews(ProductDTO productDTO);
}
