package com.camilo.webdemo.product.infrastructure.database.Specification;

import com.camilo.webdemo.product.infrastructure.database.entity.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<ProductEntity> byName(String name) {
        return ((root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }

    public static Specification<ProductEntity> byDescription(String descripcion) {
        return ((root, query, criteriaBuilder) ->
                descripcion == null ? null : criteriaBuilder.like(root.get("descripcion"), "%" + descripcion + "%"));
    }

    public static Specification<ProductEntity> byPrice(Double priceMin, Double priceMax) {
        return ((root, query, criteriaBuilder) ->
                priceMin == null || priceMax == null ? null : criteriaBuilder.between(root.get("precio"), priceMin, priceMax));
    }
}
