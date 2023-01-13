package org.parkh.b1.product.repository;

import org.parkh.b1.product.domain.Product;
import org.parkh.b1.product.repository.search.ProductSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductSearch {


}
