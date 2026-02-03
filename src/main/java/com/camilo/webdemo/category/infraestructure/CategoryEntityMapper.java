package com.camilo.webdemo.category.infraestructure;

import com.camilo.webdemo.category.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CategoryEntityMapper {
    @Mapping(target = "prodcuts", ignore = true)
    Category mapToCategory(CategoryEntity categoryEntity);
}
