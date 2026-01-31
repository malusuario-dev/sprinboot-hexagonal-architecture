package com.camilo.webdemo.product.infrastructure.database;

import com.camilo.webdemo.common.domain.PaginationQuerry;
import com.camilo.webdemo.common.domain.PaginationResult;
import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import com.camilo.webdemo.product.infrastructure.database.Specification.ProductSpecification;
import com.camilo.webdemo.product.infrastructure.database.entity.ProductEntity;
import com.camilo.webdemo.product.infrastructure.database.mapper.ProductEntityMapper;
import com.camilo.webdemo.product.infrastructure.database.repository.ProductoFilter;
import com.camilo.webdemo.product.infrastructure.database.repository.QuerryProductRepositor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepoImplement implements ProductRepository {
    private final ProductEntityMapper productEntityMapper;
    private final QuerryProductRepositor repositor;

    @Override
    public Producto upsert(Producto producto) {
        ProductEntity productEntity = productEntityMapper.mapToProductEntity(producto);
        ProductEntity save = repositor.save(productEntity);

        return productEntityMapper.mapToProdcut(save);

    }

    @Cacheable(value = "products", key = "#id")
    @Override
    public Optional<Producto> findbyid(Long id) {
        log.info("Finding prodcut whit id {}", id);
        return repositor.findById(id).map(productEntityMapper::mapToProdcut);
    }


    @Override
    public PaginationResult<Producto> findall(PaginationQuerry paginationQuerry, ProductoFilter productoFilter) {

        PageRequest pageRequest = PageRequest.of(
                paginationQuerry.getPage()
                , paginationQuerry.getSize(),
                Sort.by(Sort.Direction.fromString(paginationQuerry.getDirection()),
                        paginationQuerry.getSortBy()));

        log.info(pageRequest.toString());
        Specification<ProductEntity> specification = Specification.allOf(
                ProductSpecification.byName(productoFilter.getName()).
                        and(ProductSpecification.byDescription(productoFilter.getDescripcion()).
                                and(ProductSpecification.byPrice(productoFilter.getPriceMin(), productoFilter.getPriceMax()))));

        Page<ProductEntity> page = repositor.findAll(specification, pageRequest);
        log.info("Predicates size: {}", page.getSize());

        return new PaginationResult<>(
                page.getContent().stream().map(productEntityMapper::mapToProdcut).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalPages(),
                page.getTotalElements()
        );
    }

    @Cacheable(value = "products", key = "#id")
    @Override
    public void deleteByid(Long id) {
        repositor.deleteById(id);
    }
}
