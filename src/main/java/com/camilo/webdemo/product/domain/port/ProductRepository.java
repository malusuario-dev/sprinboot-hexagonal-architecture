package com.camilo.webdemo.product.domain.port;

import com.camilo.webdemo.common.domain.PaginationQuerry;
import com.camilo.webdemo.common.domain.PaginationResult;
import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.infrastructure.database.repository.ProductoFilter;

import java.util.Optional;

public interface ProductRepository {
    Producto upsert(Producto producto);

    Optional<Producto> findbyid(Long id);

    PaginationResult<Producto> findall(PaginationQuerry paginationQuerry, ProductoFilter productoFilter);

    void deleteByid(Long id);
}
