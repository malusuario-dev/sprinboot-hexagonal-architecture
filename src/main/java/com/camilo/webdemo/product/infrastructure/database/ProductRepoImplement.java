package com.camilo.webdemo.product.infrastructure.database;

import com.camilo.webdemo.product.domain.port.ProductRepository;
import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.infrastructure.database.entity.ProductEntity;
import com.camilo.webdemo.product.infrastructure.database.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepoImplement implements ProductRepository {
    private final List<ProductEntity> productos = new ArrayList<>();
 private  final ProductEntityMapper productEntityMapper;


    @Override
    public void upsert(Producto producto) {
        ProductEntity productEntity = productEntityMapper.mapToProductEntity(producto);
        productos.removeIf(productEntity1 -> productEntity1.getId().equals(productEntity.getId()));
        productos.add(productEntity);
    }

    @Cacheable(value = "products", key = "#id")
    @Override
    public Optional<Producto> findbyid(Long id) {
        log.info("Finding prodcut whit id {}",id);
        return productos.stream().filter(p -> p.getId().equals(id)).
                findFirst().map(productEntityMapper::mapToProdcut);    }



    @Override
    public List<Producto> findall() {
        return productos.stream().map(productEntityMapper::mapToProdcut).toList();
    }

    @Override
    public void deleteByid(Long id) {
        productos.removeIf(p -> p.getId().equals(id));
    }
}
