package com.camilo.webdemo.product.infrastructure.api.mapper;

import com.camilo.webdemo.product.application.ProductCreateRequest;
import com.camilo.webdemo.product.infrastructure.api.dto.ProuctDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProuctMapper {
    ProductCreateRequest mapToCreateProductRequest(ProuctDto prouctDto);

}
