package com.camilo.webdemo.product.application.querry.getByid;

import com.camilo.webdemo.common.mediator.RequestHandler;
import com.camilo.webdemo.product.domain.ProductRepository;
import com.camilo.webdemo.product.domain.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class getProductByidHandler implements RequestHandler<GetProductbyRequest, GetProductByidResponse> {

    private final ProductRepository productRepository;
    
    @Override
    public GetProductByidResponse handle(GetProductbyRequest requst) {
      Producto producto=  productRepository.findbyid(requst.getId()).orElseThrow(()->
                new IllegalArgumentException("prodcuto no encontrado"));
        return new GetProductByidResponse(producto);
    }

    @Override
    public Class<GetProductbyRequest> getReuestType() {
        return GetProductbyRequest.class;
    }
}
