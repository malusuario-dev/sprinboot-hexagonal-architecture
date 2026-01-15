package com.camilo.webdemo.product.infrastructure.api;

import com.camilo.webdemo.common.mediator.Mediator;
import com.camilo.webdemo.product.application.ProductCreateRequest;
import com.camilo.webdemo.product.infrastructure.api.dto.ProuctDto;
import com.camilo.webdemo.product.infrastructure.api.mapper.ProuctMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController implements ProductApi {
    private final Mediator mediator;

    private final ProuctMapper prouctMapper;

    @GetMapping("")
    public ResponseEntity<List<ProuctDto>> getProducto() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProuctDto> getProductobyid(@PathVariable Long id) {


        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<Void> saveProduct(@RequestBody ProuctDto productoDto) {
        ProductCreateRequest request = prouctMapper.mapToCreateProductRequest(productoDto);
        mediator.dispatch(request);
        return ResponseEntity.created(URI.create("/api/v1/products/".concat(String.valueOf(productoDto.getId())))).build();


    }

    @PutMapping("")
    public ResponseEntity<Void> updateProduct(@RequestBody ProuctDto prouctDto) {

        return ResponseEntity.noContent().build();


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@RequestParam Long id) {


        return ResponseEntity.noContent().build();


    }
}
