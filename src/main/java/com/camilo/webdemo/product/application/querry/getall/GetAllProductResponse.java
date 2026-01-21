package com.camilo.webdemo.product.application.querry.getall;

import com.camilo.webdemo.product.domain.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetAllProductResponse {
    private List<Producto>  productos;

}
