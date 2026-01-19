package com.camilo.webdemo.product.infrastructure.database.entity;


import lombok.Data;

@Data
public class ProductEntity {
    private  Long id;
    private String name;
    private Double precio;
    private String descripcion;
    private String image;
}
