package com.camilo.webdemo.product.application.querry.getall;

import com.camilo.webdemo.common.application.mediator.Request;
import com.camilo.webdemo.common.domain.PaginationQuerry;
import com.camilo.webdemo.product.infrastructure.database.repository.ProductoFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProductAllRequest implements Request<GetAllProductResponse> {
    PaginationQuerry paginationQuerry;
    ProductoFilter productoFilter;
}
