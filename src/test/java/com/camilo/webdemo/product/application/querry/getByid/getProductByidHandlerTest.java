package com.camilo.webdemo.product.application.querry.getByid;

import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import com.camilo.webdemo.product.domain.exception.ProductNotFoundExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetProductByidHandlerTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private getProductByidHandler handler;



    @Test
    void shouldReturnProductWhenExists() {
        // GIVEN
        Long productId = 1L;
        Producto mockproducto = Producto.builder().id(1L).build();

        when(productRepository.findbyid(productId))
                .thenReturn(Optional.of(mockproducto));

        GetProductbyRequest request = new GetProductbyRequest(productId);

        // WHEN
        GetProductByidResponse response = handler.handle(request);

        // THEN
        assertNotNull(response);
        assertEquals(mockproducto, response.getProducto());

        verify(productRepository, times(1)).findbyid(productId);
    }

    @Test
    void shouldThrowExceptionWhenProductNotFound() {
        // GIVEN
        Long productId = 99L;

        when(productRepository.findbyid(productId))
                .thenReturn(Optional.empty());

        GetProductbyRequest request = new GetProductbyRequest(productId);

        // WHEN & THEN
        assertThrows(
                ProductNotFoundExeption.class,
                () -> handler.handle(request)
        );

        verify(productRepository, times(1)).findbyid(productId);
    }
}
