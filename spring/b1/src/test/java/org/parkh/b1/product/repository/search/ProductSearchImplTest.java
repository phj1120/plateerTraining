package org.parkh.b1.product.repository.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.parkh.b1.product.dto.ProductListDTO;
import org.parkh.b1.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
@Slf4j
class ProductSearchImplTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void getList() {
        Pageable pageable = PageRequest.of(1, 100, Sort.by("pno").descending());

        Page<ProductListDTO> list = productRepository.getList(pageable);

        log.info(list.toString());
    }

}