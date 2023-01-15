package today.parkh.v0115.product.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Log4j2
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void getProductListDTOs() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());
        Page<Object[]> productListDTOs = productRepository.getProductListDTOs(pageable);

        log.info(productListDTOs);
    }

}