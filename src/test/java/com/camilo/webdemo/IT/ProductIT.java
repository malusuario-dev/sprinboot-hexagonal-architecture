package com.camilo.webdemo.IT;

import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import com.camilo.webdemo.product.infrastructure.api.dto.ProuctDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RequiredArgsConstructor
@AutoConfigureMockMvc
public class ProductIT {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestRestTemplate testTemplate;
    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.upsert(Producto.builder().id(1L).name("Product 1").descripcion("Descripcion 1").precio(100.10).build());
    }

    @AfterEach
    void tearDown() {
        productRepository.deleteByid(1L);
    }

    @Test
    public void getForProductByID() {
        ResponseEntity<ProuctDto> response =
                testTemplate.getForEntity("http://localhost:8080/api/v1/products/1", ProuctDto.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("Product 1", response.getBody().getName());
        Assertions.assertEquals("Descripcion 1", response.getBody().getDescripcion());
        Assertions.assertEquals(100.10, response.getBody().getPrecio());

    }

    @Test
    public void saveProduct() throws Exception {
        MockMultipartFile file =
                new MockMultipartFile("file", "imagen.jpeg", "imagne/jpeg", "image".getBytes());
        mockMvc.perform(multipart(HttpMethod.POST, "http://localhost:8080/api/v1/products").
                file(file).param("id", String.valueOf(2L)).
                param("name", "Name 2")
                .param("descripcion", "Descripcion 2").
                param("price", "150.00").contentType(MediaType.MULTIPART_FORM_DATA)
        ).andExpect(status().isCreated());
    }
}
