package com.camilo.webdemo.product.application.querry.getall;

import com.camilo.webdemo.common.RequestHandler;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import com.camilo.webdemo.product.domain.entity.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class getAllProductHandler implements RequestHandler<GetProductAllRequest, GetAllProductResponse> {

    private final ProductRepository productRepository;


    @Override
    public GetAllProductResponse handle(GetProductAllRequest requst) {
        List<Producto> producto=  productRepository.findall();
        return new GetAllProductResponse(producto);
    }

    @Override
    public Class<GetProductAllRequest> getReuestType() {
        return GetProductAllRequest.class;
    }
}
