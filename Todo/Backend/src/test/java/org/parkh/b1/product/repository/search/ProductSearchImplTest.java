package org.parkh.b1.product.repository.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.parkh.b1.common.domain.dto.PageReqDTO;
import org.parkh.b1.product.dto.ProductListDTO;
import org.parkh.b1.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
@Slf4j
class ProductSearchImplTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Test
    public void getList() {
        PageReqDTO pageReqDTO = new PageReqDTO(1, 5);
        Pageable pageable = pageReqDTO.getPageable(Sort.by("pno").descending());
        Page<ProductListDTO> list = productRepository.getList(pageable);

        log.info(list.toString());
        log.info("");
    }

}