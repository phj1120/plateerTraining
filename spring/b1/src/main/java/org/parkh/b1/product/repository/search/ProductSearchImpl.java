package org.parkh.b1.product.repository.search;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.parkh.b1.product.domain.Product;
import org.parkh.b1.product.domain.QFancy;
import org.parkh.b1.product.domain.QProduct;
import org.parkh.b1.product.domain.QReview;
import org.parkh.b1.product.dto.ProductListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class ProductSearchImpl extends QuerydslRepositorySupport implements ProductSearch {

    public ProductSearchImpl() {
        super(Product.class);
    }

    @Override
    public Page<ProductListDTO> getList(Pageable pageable) {
        QProduct product = QProduct.product;
        QReview review = QReview.review;
        QFancy fancy = QFancy.fancy;

        JPQLQuery<Product> query = from(product);
        query.leftJoin(review).on(review.product.eq(product))
                .leftJoin(fancy).on(fancy.product.eq(product))
                .groupBy(product);

        JPQLQuery<ProductListDTO> dtoJpqlQuery = query.select(
                Projections.bean(ProductListDTO.class,
                        product.pno,
                        product.productName,
                        product.price,
                        review.countDistinct().as("reviewCnt"),
                        fancy.countDistinct().as("fancyCnt")
                )
        );
        List<ProductListDTO> productListDTOList = dtoJpqlQuery.fetch();
        long total = dtoJpqlQuery.fetchCount();

        return new PageImpl<>(productListDTOList, pageable, total);
    }
}
