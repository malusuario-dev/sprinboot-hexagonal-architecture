package com.camilo.webdemo.category.domain;


import com.camilo.webdemo.product.domain.entity.Producto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Category {
    private Long id;
    private String name;


    List<Producto> prodcuts;
}
