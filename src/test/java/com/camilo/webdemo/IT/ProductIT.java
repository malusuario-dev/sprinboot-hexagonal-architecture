package com.camilo.webdemo.IT;

import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import com.camilo.webdemo.product.infrastructure.api.dto.ProDuctDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RequiredArgsConstructor
@AutoConfigureMockMvc
public class ProductIT {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @Qualifier("getRestTemplate")
    private TestRestTemplate getRestTemplate;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.upsert(Producto.builder().id(1L).name("Product 1").descripcion("Descripcion 1").precio(100.10).image("imagen1.png").build());
    }

    @AfterEach
    void tearDown() {
        productRepository.deleteByid(1L);
    }

    @Sql(scripts = "/it/productos/data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/it/products/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void getForProductByID() {
        ResponseEntity<ProDuctDto> response =
                getRestTemplate.getForEntity("http://localhost:8080/api/v1/products/1", ProDuctDto.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("Product 1", response.getBody().getName());
        Assertions.assertEquals("Descripcion 1", response.getBody().getDescripcion());
        Assertions.assertEquals(100.10, response.getBody().getPrecio());

    }

    @Sql(scripts = "/it/products/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

    @Test
    public void saveProduct() throws Exception {


        mockMvc.perform(multipart(HttpMethod.POST, "http://localhost:8080/api/v1/products").
                param("name", "Name 2")
                .param("descripcion", "Descripcion 2").
                param("price", "150.00").param("image", "imagen.png")
        ).andExpect(status().isCreated());
    }
}
