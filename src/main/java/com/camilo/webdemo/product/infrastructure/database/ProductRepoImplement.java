package com.camilo.webdemo.product.infrastructure.database;

import com.camilo.webdemo.product.domain.ProductRepository;
import com.camilo.webdemo.product.domain.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepoImplement implements ProductRepository {
    private final List<Producto> productos;

    public ProductRepoImplement() {
        this.productos = new ArrayList<>();
    }

    @Override
    public void upsert(Producto producto) {
        productos.add(producto);
    }

    @Override
    public Optional<Producto> findallbyid(Long id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public List<Producto> findall() {
        return productos;
    }

    @Override
    public void deleteByid(Long id) {
        productos.removeIf(p -> p.getId().equals(id));
    }
}
