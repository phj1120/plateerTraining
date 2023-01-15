package today.parkh.v0115.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import today.parkh.v0115.product.domain.Fancy;
import today.parkh.v0115.product.domain.Product;
import today.parkh.v0115.product.dto.FancyAddDTO;
import today.parkh.v0115.product.dto.FancyDTO;
import today.parkh.v0115.product.repository.FancyRepository;
import today.parkh.v0115.user.domain.User;
import today.parkh.v0115.user.service.UserService;

@Service
@Log4j2
@RequiredArgsConstructor
public class FancyServiceImpl implements FancyService {
    private final FancyRepository fancyRepository;
    private final UserService userService;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Override
    public FancyDTO addFancy(FancyAddDTO dto) {
        FancyDTO fancyDTO = modelMapper.map(dto, FancyDTO.class);
        User fancyUser = userService.findById(dto.getFancyUserId());
        Product product = productService.findById(dto.getProductId());
        Fancy fancy = new Fancy(fancyDTO, product, fancyUser);

        Fancy saveFancy = fancyRepository.save(fancy);
        FancyDTO saveFancyDTO = modelMapper.map(saveFancy, FancyDTO.class);

        return saveFancyDTO;
    }
}
