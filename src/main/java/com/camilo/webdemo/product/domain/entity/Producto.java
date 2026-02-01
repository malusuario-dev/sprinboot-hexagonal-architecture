package com.camilo.webdemo.product.domain.entity;

import com.camilo.webdemo.productDetail.domain.ProductDetail;
import com.camilo.webdemo.review.doamin.Review;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Producto {
    private Long id;
    private String name;
    private String descripcion;
    private String image;
    private Double precio;
    private ProductDetail productDetail;
    private List<Review> reviews;

}
