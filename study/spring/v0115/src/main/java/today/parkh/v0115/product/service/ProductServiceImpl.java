package today.parkh.v0115.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import today.parkh.v0115.common.domain.dto.PageReqDTO;
import today.parkh.v0115.common.domain.dto.PageResultDTO;
import today.parkh.v0115.product.domain.Product;
import today.parkh.v0115.product.dto.ProductAddDTO;
import today.parkh.v0115.product.dto.ProductDTO;
import today.parkh.v0115.product.dto.ProductListDTO;
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
    public PageResultDTO<ProductDTO> products(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        List<ProductDTO> productDTOs = productPage.getContent().stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
        int totalPages = productPage.getTotalPages();
        long totalElements = productPage.getTotalElements();

        return new PageResultDTO<>(productDTOs, pageable, totalElements, totalPages);
    }

    @Override
    public PageResultDTO<ProductDTO> products(PageReqDTO pageReqDTO, Sort sort) {
        Pageable pageable = pageReqDTO.getPageable(sort);

        return products(pageable);
    }

    @Override
    public Product findById(Long productId) {

        return productRepository.findById(productId).orElseThrow(() -> {
            throw new RuntimeException();
        });
    }

    @Override
    public PageResultDTO<ProductListDTO> productListDTO(Pageable pageable) {
        Page<Object[]> productListDTOs = productRepository.getProductListDTOs(pageable);
        long totalElements = productListDTOs.getTotalElements();
        int totalPages = productListDTOs.getTotalPages();
        List<ProductListDTO> productListDTOS = productListDTOs.getContent().stream()
                .map((objects -> {
                    Product product = (Product) objects[0];
                    User user = (User) objects[1];
                    long replyCount = (long) objects[2];
                    long fancyCount = (long) objects[3];

                    return new ProductListDTO(product, user, replyCount, fancyCount);
                })).collect(Collectors.toList());

        return new PageResultDTO<ProductListDTO>(productListDTOS, pageable, totalElements, totalPages);
    }
}
