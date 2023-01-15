package today.parkh.v0115.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import today.parkh.v0115.product.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p, u, count(r), count(f)" +
            " from Product p left join Review r on p = r.product" +
            " left join Fancy f on p = f.product" +
            " left join User u on p.seller = u" +
            " group by p")
    Page<Object[]> getProductListDTOs(Pageable pageable);
}
