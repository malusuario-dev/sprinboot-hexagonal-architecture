package com.camilo.webdemo.product.infrastructure.database.seeder;


import com.camilo.webdemo.product.infrastructure.database.entity.ProductEntity;
import com.camilo.webdemo.product.infrastructure.database.repository.QuerryProductRepositor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductSeeder implements CommandLineRunner {

    private final QuerryProductRepositor productRepository;
    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        long count = productRepository.count();

        if (count == 0) {

            Resource resource = resourceLoader.getResource("classpath:data.json");
            List<ProductEntity> products = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
            });

            productRepository.saveAll(products);
            log.info("productos guardados");
        }
    }
}
