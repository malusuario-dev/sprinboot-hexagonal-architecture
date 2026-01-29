package com.camilo.webdemo.product.application.comandos.create;

import com.camilo.webdemo.product.domain.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCreateResponse {
    private Producto product;

}
