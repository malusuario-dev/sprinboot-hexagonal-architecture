package com.camilo.webdemo.product.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Producto {
    private Long id;
    private String name;
    private String descripcion;
    private String image;
    private Double precio;
}
