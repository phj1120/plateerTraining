package com.plateer.todo.product.repository.search;

import com.plateer.todo.product.domain.Product;
import com.plateer.todo.product.domain.QFancy;
import com.plateer.todo.product.domain.QProduct;
import com.plateer.todo.product.domain.QReview;
import com.plateer.todo.product.dto.ProductListDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

@Log4j2
public class ProductSearchImpl extends QuerydslRepositorySupport implements ProductSearch {

    public ProductSearchImpl(){
        super(Product.class);
    }

    @Override
    public Page<ProductListDTO> getList(Pageable pageable) {

        QProduct product = QProduct.product;
        QReview review = QReview.review;
        QFancy fancy = QFancy.fancy;

        JPQLQuery<Product> query =
                from(product);
        query.leftJoin(review).on(review.product.eq(product));
        query.leftJoin(fancy).on(fancy.product.eq(product));

        query.groupBy(product);

        JPQLQuery<ProductListDTO> dtojpqlQuery =
            query.select(
                Projections.bean(ProductListDTO.class,
                    product.pno,
                        product.pname,
                        product.price,
                        review.countDistinct().as("reviewCnt"),
                        fancy.countDistinct().as("fancyCnt")
                ));

        Page<ProductListDTO> result =
                new PageImpl<>(dtojpqlQuery.fetch(), pageable,dtojpqlQuery.fetchCount());

        return result;
    }
}



















