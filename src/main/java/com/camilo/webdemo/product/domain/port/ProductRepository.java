package com.camilo.webdemo.product.domain.port;

import com.camilo.webdemo.product.domain.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void upsert(Producto producto);

    Optional<Producto> findbyid(Long id);

    List<Producto> findall();

    void deleteByid(Long id);
}
