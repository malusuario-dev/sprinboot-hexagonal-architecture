package com.camilo.webdemo.product.domain.port;

import com.camilo.webdemo.common.domain.PaginationQuerry;
import com.camilo.webdemo.common.domain.PaginationResult;
import com.camilo.webdemo.product.domain.entity.Producto;

import java.util.Optional;

public interface ProductRepository {
    Producto upsert(Producto producto);

    Optional<Producto> findbyid(Long id);

    PaginationResult<Producto> findall(PaginationQuerry paginationQuerry);

    void deleteByid(Long id);
}
