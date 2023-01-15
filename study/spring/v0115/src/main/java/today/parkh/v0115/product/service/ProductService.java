package today.parkh.v0115.product.service;

import today.parkh.v0115.product.dto.ProductAddDTO;
import today.parkh.v0115.product.dto.ProductDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductService {
    ProductDTO addProduct(ProductAddDTO dto);

    List<ProductDTO> products();
}
