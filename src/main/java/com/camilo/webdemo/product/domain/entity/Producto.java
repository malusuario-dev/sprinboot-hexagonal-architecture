package com.camilo.webdemo.product.domain.entity;

import com.camilo.webdemo.productDetail.domain.ProductDetail;
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
    private ProductDetail productDetail;

}
