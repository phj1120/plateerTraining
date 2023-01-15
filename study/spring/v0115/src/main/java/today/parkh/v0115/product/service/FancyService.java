package today.parkh.v0115.product.service;

import today.parkh.v0115.product.dto.FancyAddDTO;
import today.parkh.v0115.product.dto.FancyDTO;

import javax.transaction.Transactional;

@Transactional
public interface FancyService {
    FancyDTO addFancy(FancyAddDTO dto);
}
