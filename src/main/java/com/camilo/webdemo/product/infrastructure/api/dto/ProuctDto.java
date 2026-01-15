package com.camilo.webdemo.product.infrastructure.api.dto;

import lombok.Data;


@Data
public class ProuctDto {
    private final long id;
    private String name;
    private Double precio;
    private String descripcion;
    private String image;
}
