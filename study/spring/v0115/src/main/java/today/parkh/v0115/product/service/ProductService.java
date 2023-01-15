package today.parkh.v0115.product.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import today.parkh.v0115.common.domain.dto.PageReqDTO;
import today.parkh.v0115.common.domain.dto.PageResultDTO;
import today.parkh.v0115.product.domain.Product;
import today.parkh.v0115.product.dto.ProductAddDTO;
import today.parkh.v0115.product.dto.ProductDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductService {
    ProductDTO addProduct(ProductAddDTO dto);

    List<ProductDTO> products();

    PageResultDTO<ProductDTO> products(Pageable pageable);

    PageResultDTO<ProductDTO> products(PageReqDTO pageReqDTO, Sort sort);

    Product findById(Long productId);
}
