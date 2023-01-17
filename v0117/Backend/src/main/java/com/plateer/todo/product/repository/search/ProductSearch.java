package com.plateer.todo.product.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.plateer.todo.product.dto.ProductListDTO;

public interface ProductSearch {

    Page<ProductListDTO> getList(Pageable pageable);

}
