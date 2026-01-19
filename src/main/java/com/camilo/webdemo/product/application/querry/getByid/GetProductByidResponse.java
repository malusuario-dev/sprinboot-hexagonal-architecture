package com.camilo.webdemo.product.application.querry.getByid;

import com.camilo.webdemo.product.domain.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProductByidResponse {
    private Producto producto;

}
