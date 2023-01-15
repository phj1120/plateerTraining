package today.parkh.v0115.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import today.parkh.v0115.product.domain.Product;
import today.parkh.v0115.product.domain.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByProduct(Product product);
}
