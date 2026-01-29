package com.camilo.webdemo.product.application.querry.getByid;

import com.camilo.webdemo.common.application.mediator.RequestHandler;
import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.domain.exception.ProductNotFoundExeption;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class getProductByidHandler implements RequestHandler<GetProductbyRequest, GetProductByidResponse> {


    private final ProductRepository productRepository;

    @Override
    public GetProductByidResponse handle(GetProductbyRequest requst) {
        Producto producto = productRepository.findbyid(requst.getId()).orElseThrow(() ->
                new ProductNotFoundExeption(requst.getId()));
        return new GetProductByidResponse(producto);
    }

    @Override
    public Class<GetProductbyRequest> getReuestType() {
        return GetProductbyRequest.class;
    }
}
