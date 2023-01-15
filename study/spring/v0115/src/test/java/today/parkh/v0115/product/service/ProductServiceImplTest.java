package today.parkh.v0115.product.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import today.parkh.v0115.common.domain.dto.PageReqDTO;
import today.parkh.v0115.common.domain.dto.PageResultDTO;
import today.parkh.v0115.product.dto.ProductAddDTO;
import today.parkh.v0115.product.dto.ProductDTO;
import today.parkh.v0115.user.dto.UserAddDTO;
import today.parkh.v0115.user.dto.UserDTO;
import today.parkh.v0115.user.service.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Test
    void addProduct() {
        UserAddDTO userAddDTO = new UserAddDTO("name");
        UserDTO userDTO = userService.saveUser(userAddDTO);
        log.info(userDTO);

        ProductAddDTO productAddDTO = new ProductAddDTO("productName", 1000, userDTO.getUid());
        ProductDTO productDTO = productService.addProduct(productAddDTO);
        log.info(productDTO);
    }

    @Test
    void products() {
        List<ProductDTO> products = productService.products();

        log.info(products);
    }


    @Test
    void productsPageable() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());
        PageResultDTO<ProductDTO> products = productService.products(pageable);

        log.info(products);
    }

    @Test
    void productsPageableByPageReqDTO() {
        PageReqDTO pageReqDTO = new PageReqDTO(1, 10);
        Sort sort = Sort.by("pno").descending();
        PageResultDTO<ProductDTO> products = productService.products(pageReqDTO, sort);

        log.info(products);
    }
}