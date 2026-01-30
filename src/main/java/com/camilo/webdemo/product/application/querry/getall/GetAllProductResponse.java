package com.camilo.webdemo.product.application.querry.getall;

import com.camilo.webdemo.common.domain.PaginationResult;
import com.camilo.webdemo.product.domain.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAllProductResponse {
    private PaginationResult<Producto> productsPage;

}
