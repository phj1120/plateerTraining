package com.plateer.todo.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.plateer.todo.product.domain.Product;
import com.plateer.todo.product.repository.search.ProductSearch;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductSearch {

}
