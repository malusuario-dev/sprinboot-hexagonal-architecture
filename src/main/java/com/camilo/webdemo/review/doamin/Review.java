package com.camilo.webdemo.review.doamin;


import com.camilo.webdemo.product.domain.entity.Producto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Review {

    private Long id;
    private Integer rating;
    private String comment;

    private Producto producto;
}
