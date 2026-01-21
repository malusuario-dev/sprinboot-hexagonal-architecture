package com.camilo.webdemo.product.infrastructure.api;

import com.camilo.webdemo.common.mediator.Mediator;
import com.camilo.webdemo.product.application.comandos.create.ProductCreateRequest;
import com.camilo.webdemo.product.application.comandos.delete.DeleteProductRequest;
import com.camilo.webdemo.product.application.comandos.update.ProductUpdateRequest;
import com.camilo.webdemo.product.application.querry.getByid.GetProductByidResponse;
import com.camilo.webdemo.product.application.querry.getByid.GetProductbyRequest;
import com.camilo.webdemo.product.application.querry.getall.GetAllProductResponse;
import com.camilo.webdemo.product.application.querry.getall.GetProductAllRequest;
import com.camilo.webdemo.product.infrastructure.api.dto.CreateProuctDto;
import com.camilo.webdemo.product.infrastructure.api.dto.ProuctDto;
import com.camilo.webdemo.product.infrastructure.api.dto.UpdateProuctDto;
import com.camilo.webdemo.product.infrastructure.api.mapper.ProuctMapper;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<ProuctDto>> getProducto(@RequestParam(required = false)String pagesize) {

        GetAllProductResponse response = mediator.dispatch(new GetProductAllRequest());

        List<ProuctDto> prudctsDtos = response.getProductos().stream().map(prouctMapper::mapToProduct).toList();

        return ResponseEntity.ok(prudctsDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProuctDto> getProductobyid(@PathVariable Long id) {

        GetProductByidResponse response = mediator.dispatch(new GetProductbyRequest(id));
        ProuctDto prouctDto = prouctMapper.mapToProduct(response.getProducto());

        return ResponseEntity.ok(prouctDto);
    }

    @PostMapping("")
    public ResponseEntity<Void> saveProduct(@Valid @ModelAttribute CreateProuctDto productoDto) {
        ProductCreateRequest request = prouctMapper.mapToCreateProductRequest(productoDto);
        mediator.dispatch(request);
        return ResponseEntity.created(URI.create("/api/v1/products/".concat(productoDto.getId().toString()))).build();

    }

    @PutMapping("")
    public ResponseEntity<Void> updateProduct(@Valid @ModelAttribute UpdateProuctDto prouctDto) {
        ProductUpdateRequest request = prouctMapper.mapToUpdateProductRequest(prouctDto);
        mediator.dispatch(request);
        return ResponseEntity.noContent().build();


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        mediator.dispatch(new DeleteProductRequest(id));

        return ResponseEntity.noContent().build();


    }
}
