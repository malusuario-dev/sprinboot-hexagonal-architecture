package com.camilo.webdemo.productDetail.domain;

import com.camilo.webdemo.product.domain.entity.Producto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDetail {
    private Long id;
    private String specifications;
    private String warranty;
    private String provider;
    private Producto producto;
}
