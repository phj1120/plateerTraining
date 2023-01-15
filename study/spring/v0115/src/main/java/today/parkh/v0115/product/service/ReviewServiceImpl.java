package today.parkh.v0115.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import today.parkh.v0115.product.domain.Product;
import today.parkh.v0115.product.domain.Review;
import today.parkh.v0115.product.dto.ProductDTO;
import today.parkh.v0115.product.dto.ReviewAddDTO;
import today.parkh.v0115.product.dto.ReviewDTO;
import today.parkh.v0115.product.repository.ReviewRepository;
import today.parkh.v0115.user.domain.User;
import today.parkh.v0115.user.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductService productService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public ReviewDTO addReview(ReviewAddDTO dto) {
        ReviewDTO reviewDTO = modelMapper.map(dto, ReviewDTO.class);
        Product product = productService.findById(dto.getProductId());
        User reviewer = userService.findById(dto.getReviewerId());

        Review review = new Review(reviewDTO, product, reviewer);
        Review saveReview = reviewRepository.save(review);
        ReviewDTO saveReviewDTO = modelMapper.map(saveReview, ReviewDTO.class);

        return saveReviewDTO;
    }

    @Override
    public List<ReviewDTO> reviews(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        List<Review> reviews = reviewRepository.findByProduct(product);

        return reviews.stream()
                .map((review -> modelMapper.map(review, ReviewDTO.class)))
                .collect(Collectors.toList());
    }
}
