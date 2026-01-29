package com.camilo.webdemo.product.infrastructure.api;

import com.camilo.webdemo.common.application.mediator.Mediator;
import com.camilo.webdemo.product.infrastructure.api.mapper.ProuctMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @Mock
    private Mediator mediator;
    @Mock
    private ProuctMapper prouctMapper;
    @InjectMocks
    private ProductController productController;


//    @Test
//    public void getAllProdcuts() {
//
//        GetAllProductResponse getAllProductResponse = new GetAllProductResponse(List.of(
//                Producto.builder().id(1L).build(),
//                Producto.builder().id(2L).build()
//
//        ));
//        when(mediator.dispatch(new GetProductAllRequest())).thenReturn(getAllProductResponse);
//        ProDuctDto proDuctDto = new ProDuctDto();
//        proDuctDto.setId(1L);
//        when(prouctMapper.mapToProductDto(any(Producto.class))).thenReturn(proDuctDto);
//        ResponseEntity<List<ProDuctDto>> response
//                = productController.getAllProducto("5");
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//
//        List<ProDuctDto> products = response.getBody();
//        assertEquals(2, products.size());
//
//    }

}