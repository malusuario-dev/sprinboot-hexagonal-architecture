package com.camilo.webdemo.product.infrastructure.api.mapper;

import com.camilo.webdemo.product.application.comandos.create.ProductCreateRequest;
import com.camilo.webdemo.product.application.comandos.update.ProductUpdateRequest;
import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.infrastructure.api.dto.CreateProuctDto;
import com.camilo.webdemo.product.infrastructure.api.dto.ProuctDto;
import com.camilo.webdemo.product.infrastructure.api.dto.UpdateProuctDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProuctMapper {
    @Mapping(target = "id", source = "id")
    ProductCreateRequest mapToCreateProductRequest(CreateProuctDto prouctDto);
    ProductUpdateRequest mapToUpdateProductRequest(UpdateProuctDto prouctDto);

    ProuctDto mapToProductDto(Producto producto);

}
