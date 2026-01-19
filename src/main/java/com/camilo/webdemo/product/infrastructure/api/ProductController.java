package com.camilo.webdemo.product.infrastructure.api;

import com.camilo.webdemo.common.mediator.Mediator;
import com.camilo.webdemo.product.application.comandos.create.ProductCreateRequest;
import com.camilo.webdemo.product.application.querry.getByid.GetProductByidResponse;
import com.camilo.webdemo.product.application.querry.getByid.GetProductbyRequest;
import com.camilo.webdemo.product.domain.Producto;
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

        GetProductByidResponse response = mediator.dispatch(new GetProductbyRequest(id));
        ProuctDto prouctDto = prouctMapper.mapToProduct(response.getProducto());

        return ResponseEntity.ok(prouctDto);
    }

    @PostMapping("")
    public ResponseEntity<Void> saveProduct(@RequestBody ProuctDto productoDto) {
        ProductCreateRequest request = prouctMapper.mapToCreateProductRequest(productoDto);
        mediator.dispatch(request);
        return ResponseEntity.created(URI.create("/api/v1/products/".concat(productoDto.getId().toString()))).build();

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
