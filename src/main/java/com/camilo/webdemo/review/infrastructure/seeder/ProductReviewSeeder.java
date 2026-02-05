package com.camilo.webdemo.review.infrastructure.seeder;

import com.camilo.webdemo.review.infrastructure.ReviewEntity;
import com.camilo.webdemo.review.infrastructure.repo.QuerryProductReviewsRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
@Slf4j
@Profile("!test")

public class ProductReviewSeeder implements CommandLineRunner {
    private final QuerryProductReviewsRepo productRepository;
    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        long count = productRepository.count();

        if (count == 0) {

            Resource resource = resourceLoader.getResource("classpath:product_reviews.json");
            List<ReviewEntity> productDetailEntityList = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
            });

            productRepository.saveAll(productDetailEntityList);
            log.info("productos guardados");
        }
    }
}
