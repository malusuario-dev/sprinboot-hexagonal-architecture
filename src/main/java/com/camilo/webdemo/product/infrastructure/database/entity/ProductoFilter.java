package com.camilo.webdemo.product.infrastructure.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoFilter {
    private String name;
    private String descripcion;
    private Double priceMin;
    private Double priceMax;

}
