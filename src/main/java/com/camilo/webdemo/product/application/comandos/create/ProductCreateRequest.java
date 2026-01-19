package com.camilo.webdemo.product.application.comandos.create;

import com.camilo.webdemo.common.mediator.Request;
import lombok.Data;

@Data

public class ProductCreateRequest implements Request<Void> {
    private Long id;
    private String name;
    private Double precio;
    private String descripcion;
    private String image;
}
