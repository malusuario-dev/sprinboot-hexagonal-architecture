package com.camilo.webdemo.product.application.comandos.create;

import com.camilo.webdemo.common.mediator.RequestHandler;
import com.camilo.webdemo.product.domain.ProductRepository;
import com.camilo.webdemo.product.domain.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductCreateHandler implements RequestHandler<ProductCreateRequest, Void> {

    private final ProductRepository productRepository;


    @Override
    public Void handle(ProductCreateRequest requst) {
        Producto producto = Producto.builder().
                name(requst.getName())
                .descripcion(requst.getDescripcion()).
                image(requst.getImage())
                .precio(requst.getPrecio()).id(requst.getId()).build();
        productRepository.upsert(producto);
        return null;
    }

    @Override
    public Class<ProductCreateRequest> getReuestType() {
        return ProductCreateRequest.class;
    }
}
