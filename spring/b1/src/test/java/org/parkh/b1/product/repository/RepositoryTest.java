package org.parkh.b1.product.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.parkh.b1.product.domain.Fancy;
import org.parkh.b1.product.domain.Product;
import org.parkh.b1.product.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
class RepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    FancyRepository fancyRepository;

    @Test
    public void initProduct() {
        IntStream.rangeClosed(1, 10).forEach((i) -> {
            Product product = Product.builder()
                    .pname("pname" + i)
                    .price(i * 100)
                    .build();
            productRepository.save(product);

            int cnt1 = (int) (Math.random() * 5);
            IntStream.rangeClosed(1, cnt1).forEach((j) -> {
                Review review = Review.builder()
                        .product(product)
                        .text("text" + j)
                        .build();
                reviewRepository.save(review);
            });

            int cnt2 = (int) (Math.random() * 5);
            IntStream.rangeClosed(1, cnt2).forEach((k) -> {
                Fancy fancy = Fancy.builder()
                        .product(product)
                        .fwriter("writer" + k)
                        .build();
                fancyRepository.save(fancy);
            });
        });
    }


}