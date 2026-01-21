package com.camilo.webdemo.product.application.comandos.delete;

import com.camilo.webdemo.common.RequestHandler;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDeleteHandler implements RequestHandler<DeleteProductRequest, Void> {

    private final ProductRepository productRepository;


    @Override
    public Void handle(DeleteProductRequest requst) {

        productRepository.deleteByid(requst.getId());
        return null;
    }

    @Override
    public Class<DeleteProductRequest> getReuestType() {
        return DeleteProductRequest.class;
    }
}
