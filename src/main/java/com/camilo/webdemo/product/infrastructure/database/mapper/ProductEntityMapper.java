package com.camilo.webdemo.product.infrastructure.database.mapper;

import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.infrastructure.database.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductEntityMapper {
    @Mapping(target = "productDetailEntity", source = "productDetail")
    @Mapping(target = "productDetailEntity.product", ignore = true)
    ProductEntity mapToProductEntity(Producto producto);

    @Mapping(target = "productDetail", source = "productDetailEntity")
    @Mapping(target = "productDetail.producto", ignore = true)
    Producto mapToProduct(ProductEntity productEntity);
}
