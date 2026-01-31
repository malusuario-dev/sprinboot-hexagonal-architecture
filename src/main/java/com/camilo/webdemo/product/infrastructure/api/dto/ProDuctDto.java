package com.camilo.webdemo.product.infrastructure.api.dto;

import lombok.Data;


@Data
public class ProDuctDto {

    private Long id;
    private String name;
    private Double precio;
    private String descripcion;
    private String image;
    private String provider;
}
