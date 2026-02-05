package com.camilo.webdemo.product.infrastructure.database;

import com.camilo.webdemo.product.infrastructure.database.entity.ProductEntity;
import com.camilo.webdemo.product.infrastructure.database.repository.QuerryProductRepositor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
class ProductRepoUpdateTest {


    @Autowired
    private QuerryProductRepositor repositor;


    @Test
    void shouldReturnProducthenwhennotFound() {
        Optional<ProductEntity> optionalProducto = repositor.findById(1L);
        assertTrue(optionalProducto.isEmpty());
    }

    @Test
    void shouldReturnProducthenFound() {
        ProductEntity productEntity = new ProductEntity();
        ProductEntity save = repositor.save(productEntity);
        Optional<ProductEntity> optionalProducto = repositor.findById(save.getId());
        assertTrue(optionalProducto.isPresent());
    }
}