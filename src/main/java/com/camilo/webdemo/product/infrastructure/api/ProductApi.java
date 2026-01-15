package com.camilo.webdemo.product.infrastructure.api;

import com.camilo.webdemo.product.infrastructure.api.dto.ProuctDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductApi {
    public ResponseEntity<List<ProuctDto>> getProducto();

    public ResponseEntity<ProuctDto> getProductobyid(@PathVariable Long id);

    public ResponseEntity<Void> saveProduct(@RequestBody ProuctDto productoDto);

    public ResponseEntity<Void> updateProduct(@RequestBody ProuctDto productoDto);

    public ResponseEntity<Void> deleteProduct(@RequestParam Long id);
}
