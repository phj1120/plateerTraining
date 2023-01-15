package today.parkh.v0115.product.service;

import today.parkh.v0115.product.domain.Product;
import today.parkh.v0115.product.dto.ReviewDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ReviewService {
    ReviewDTO addReview(ReviewDTO dto);

    List<ReviewDTO> review(Product product);
}
