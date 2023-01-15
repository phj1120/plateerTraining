package today.parkh.v0115.product.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import today.parkh.v0115.product.dto.FancyAddDTO;
import today.parkh.v0115.product.dto.FancyDTO;
import today.parkh.v0115.product.dto.ProductAddDTO;
import today.parkh.v0115.product.dto.ProductDTO;
import today.parkh.v0115.user.dto.UserAddDTO;
import today.parkh.v0115.user.dto.UserDTO;
import today.parkh.v0115.user.service.UserService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class FancyServiceImplTest {
    @Autowired
    private FancyService fancyService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @Test
    void addFancy() {
        UserAddDTO sellerAddDTO = new UserAddDTO("seller");
        UserDTO sellerDTO = userService.saveUser(sellerAddDTO);
        log.info(sellerDTO);

        UserAddDTO fancyUserAddDTO = new UserAddDTO("fancy user");
        UserDTO fancyUserDTO = userService.saveUser(fancyUserAddDTO);
        log.info(fancyUserDTO);

        ProductAddDTO productAddDTO = new ProductAddDTO("productName", 1000, sellerDTO.getUid());
        ProductDTO productDTO = productService.addProduct(productAddDTO);
        log.info(productDTO);

        FancyAddDTO fancyAddDTO = new FancyAddDTO(productDTO.getPno(), fancyUserDTO.getUid());
        FancyDTO fancyDTO = fancyService.addFancy(fancyAddDTO);

        log.info(fancyDTO);
    }
}