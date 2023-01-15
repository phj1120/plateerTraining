package today.parkh.v0115.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import today.parkh.v0115.product.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
