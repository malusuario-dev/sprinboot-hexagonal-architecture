package com.camilo.webdemo.productDetail.infrastructure;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
@Slf4j
public class ProductDetailSeeder implements CommandLineRunner {
    private final QuerryProductDetailRepo productRepository;
    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        long count = productRepository.count();

        if (count == 0) {

            Resource resource = resourceLoader.getResource("classpath:products_details.json");
            List<ProductDetailEntity> productDetailEntityList = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
            });

            productRepository.saveAll(productDetailEntityList);
            log.info("productos guardados");
        }
    }
}
