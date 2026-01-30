package com.camilo.webdemo.product.infrastructure.api;

import com.camilo.webdemo.common.domain.PaginationResult;
import com.camilo.webdemo.product.infrastructure.api.dto.CreateProuctDto;
import com.camilo.webdemo.product.infrastructure.api.dto.ProDuctDto;
import com.camilo.webdemo.product.infrastructure.api.dto.UpdateProuctDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductApi {
    public ResponseEntity<PaginationResult<ProDuctDto>> getAllProducto(int pageNumber, int PageSie);

    public ResponseEntity<ProDuctDto> getProductobyid(@PathVariable Long id);

    public ResponseEntity<Void> saveProduct(@RequestBody CreateProuctDto productoDto);

    public ResponseEntity<Void> updateProduct(@RequestBody UpdateProuctDto productoDto);

    public ResponseEntity<Void> deleteProduct(@PathVariable Long id);
}
