package today.parkh.v0115.product.service;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import today.parkh.v0115.product.dto.ProductAddDTO;
import today.parkh.v0115.product.dto.ProductDTO;
import today.parkh.v0115.product.dto.ReviewAddDTO;
import today.parkh.v0115.product.dto.ReviewDTO;
import today.parkh.v0115.user.dto.UserAddDTO;
import today.parkh.v0115.user.dto.UserDTO;
import today.parkh.v0115.user.service.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class ReviewServiceImplTest {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @Test
    void addReview() {
        UserDTO seller = userService.saveUser(new UserAddDTO("seller"));
        ProductDTO product = productService.addProduct(new ProductAddDTO("productName", 1000, seller.getUid()));

        UserDTO reviewer = userService.saveUser(new UserAddDTO("reviewer"));
        ReviewAddDTO reviewAddDTO = new ReviewAddDTO("title", "content", product.getPno(), reviewer.getUid());
        ReviewDTO reviewDTO = reviewService.addReview(reviewAddDTO);

        log.info(reviewDTO);
    }

    @Test
    void reviews() {
        UserDTO seller = userService.saveUser(new UserAddDTO("seller"));
        ProductDTO product = productService.addProduct(new ProductAddDTO("productName", 1000, seller.getUid()));

        UserDTO reviewer = userService.saveUser(new UserAddDTO("reviewer"));
        ReviewAddDTO reviewAddDTO = new ReviewAddDTO("title", "content", product.getPno(), reviewer.getUid());
        ReviewDTO reviewDTO = reviewService.addReview(reviewAddDTO);

        List<ReviewDTO> reviews = reviewService.reviews(product);
        log.info(reviews);
    }
}