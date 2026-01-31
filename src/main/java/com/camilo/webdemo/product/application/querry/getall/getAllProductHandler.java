package com.camilo.webdemo.product.application.querry.getall;

import com.camilo.webdemo.common.application.mediator.RequestHandler;
import com.camilo.webdemo.common.domain.PaginationResult;
import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class getAllProductHandler implements RequestHandler<GetProductAllRequest, GetAllProductResponse> {

    private final ProductRepository productRepository;


    @Override
    public GetAllProductResponse handle(GetProductAllRequest requst) {
        PaginationResult<Producto> producto = productRepository.findall(requst.getPaginationQuerry(), requst.getProductoFilter());
        return new GetAllProductResponse(producto);
    }

    @Override
    public Class<GetProductAllRequest> getReuestType() {
        return GetProductAllRequest.class;
    }
}
