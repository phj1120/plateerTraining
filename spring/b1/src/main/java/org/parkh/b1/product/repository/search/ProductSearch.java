package org.parkh.b1.product.repository.search;

import org.parkh.b1.product.dto.ProductListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductSearch {
    // PageReqDTO 써도 괜찮음
    Page<ProductListDTO> getList(Pageable pageable);
}
