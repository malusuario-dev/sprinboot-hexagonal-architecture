package com.camilo.webdemo.product.application.querry.getByid;

import com.camilo.webdemo.product.domain.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProductByidResponse {
    private Producto producto;

}
