package com.camilo.webdemo.product.application.querry.getall;

import com.camilo.webdemo.common.application.mediator.RequestHandler;
import com.camilo.webdemo.common.domain.PaginationResult;
import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class getAllProductHandler implements RequestHandler<GetProductAllRequest, GetAllProductResponse> {

    private final ProductRepository productRepository;


    @Override
    public GetAllProductResponse handle(GetProductAllRequest requst) {
        PaginationResult<Producto> producto = productRepository.findall(requst.getPaginationQuerry());
        return new GetAllProductResponse(producto);
    }

    @Override
    public Class<GetProductAllRequest> getReuestType() {
        return GetProductAllRequest.class;
    }
}
