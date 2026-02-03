package com.camilo.webdemo.product.application.comandos.update;

import com.camilo.webdemo.common.application.mediator.Request;
import com.camilo.webdemo.review.doamin.Review;
import lombok.Data;

@Data

public class ProductUpdateRequest implements Request<Void> {
    private Long id;
    private String name;
    private Double precio;
    private String descripcion;
    private String provider;
    private Review review;
    private Long category;

}
