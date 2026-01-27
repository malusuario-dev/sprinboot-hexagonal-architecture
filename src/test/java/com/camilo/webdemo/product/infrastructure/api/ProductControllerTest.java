package com.camilo.webdemo.product.infrastructure.api;

import com.camilo.webdemo.common.mediator.Mediator;
import com.camilo.webdemo.product.application.querry.getall.GetAllProductResponse;
import com.camilo.webdemo.product.application.querry.getall.GetProductAllRequest;
import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.infrastructure.api.dto.ProuctDto;
import com.camilo.webdemo.product.infrastructure.api.mapper.ProuctMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @Mock
    private Mediator mediator;
      @Mock
    private  ProuctMapper prouctMapper;
    @InjectMocks
    private  ProductController productController;


    @Test
     public void getAllProdcuts(){

        GetAllProductResponse getAllProductResponse = new GetAllProductResponse(List.of(
           Producto.builder().id(1L).build(),
                Producto.builder().id(2L).build()

        ));
        when(mediator.dispatch(new GetProductAllRequest())).thenReturn(getAllProductResponse);
        ProuctDto prouctDto = new ProuctDto();
        prouctDto.setId(1L);
        when(prouctMapper.mapToProductDto(any(Producto.class))).thenReturn(prouctDto);
         ResponseEntity<List<ProuctDto>> response
                 = productController.getProducto("5");

       assertEquals(HttpStatus.OK, response.getStatusCode());
         assertNotNull(response.getBody());

         List<ProuctDto> products = response.getBody();
         assertEquals(2,products.size());

     }

}