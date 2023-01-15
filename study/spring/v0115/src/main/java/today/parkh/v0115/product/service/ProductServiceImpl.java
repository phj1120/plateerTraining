package today.parkh.v0115.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import today.parkh.v0115.product.domain.Product;
import today.parkh.v0115.product.dto.ProductAddDTO;
import today.parkh.v0115.product.dto.ProductDTO;
import today.parkh.v0115.product.repository.ProductRepository;
import today.parkh.v0115.user.domain.User;
import today.parkh.v0115.user.service.UserService;

import java.util.List;
import java.util.stream.Collectors;


@Log4j2
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final UserService userService;

    @Override
    public ProductDTO addProduct(ProductAddDTO dto) {
        ProductDTO productDTO = modelMapper.map(dto, ProductDTO.class);
        User seller = userService.findById(dto.getSellerId());
        Product product = new Product(productDTO, seller);
        Product saveProduct = productRepository.save(product);
        ProductDTO saveProductDTO = modelMapper.map(saveProduct, ProductDTO.class);

        return saveProductDTO;
    }

    @Override
    public List<ProductDTO> products() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Product findById(Long productId) {

        return productRepository.findById(productId).orElseThrow(() -> {
            throw new RuntimeException();
        });
    }
}
