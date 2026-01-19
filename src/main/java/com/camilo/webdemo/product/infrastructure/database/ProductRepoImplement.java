package com.camilo.webdemo.product.infrastructure.database;

import com.camilo.webdemo.product.domain.ProductRepository;
import com.camilo.webdemo.product.domain.Producto;
import com.camilo.webdemo.product.infrastructure.database.entity.ProductEntity;
import com.camilo.webdemo.product.infrastructure.database.mapper.ProductEntityMapper;
import com.camilo.webdemo.product.infrastructure.database.mapper.ProductEntityMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepoImplement implements ProductRepository {
    private final List<ProductEntity> productos = new ArrayList<>();
 private  final ProductEntityMapper productEntityMapper;


    @Override
    public void upsert(Producto producto) {
        ProductEntity productEntity = productEntityMapper.mapToProductEntity(producto);

        productos.add(productEntity);
    }

    @Override
    public Optional<Producto> findbyid(Long id) {
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
