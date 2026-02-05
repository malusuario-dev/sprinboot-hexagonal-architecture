package com.camilo.webdemo.product.infrastructure.database;

import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.infrastructure.database.entity.ProductEntity;
import com.camilo.webdemo.product.infrastructure.database.mapper.ProductEntityMapper;
import com.camilo.webdemo.product.infrastructure.database.repository.QuerryProductRepositor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductRepoImplementTest {

    @Mock
    private ProductEntityMapper productEntityMapper;
    @Mock
    private QuerryProductRepositor repositor;
    @InjectMocks
    private ProductRepoImplement productRepoImplement;

    @Test
    void shouldReturnProducthenwhennotFound() {
        Optional<Producto> optionalProducto = productRepoImplement.findbyid(1L);
        assertTrue(optionalProducto.isEmpty());
    }

    @Test
    void shouldReturnProducthenFound() {
        when(repositor.findById(1L)).thenReturn(Optional.of(new ProductEntity()));
        when(productEntityMapper.mapToProduct(any(ProductEntity.class))).thenReturn(Producto.builder().id(1L).build());
        Optional<Producto> optionalProducto = productRepoImplement.findbyid(1L);
        assertTrue(optionalProducto.isPresent());
    }
}