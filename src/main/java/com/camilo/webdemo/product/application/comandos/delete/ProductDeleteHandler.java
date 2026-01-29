package com.camilo.webdemo.product.application.comandos.delete;

import com.camilo.webdemo.common.application.mediator.RequestHandler;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDeleteHandler implements RequestHandler<DeleteProductRequest, Void> {

    private final ProductRepository productRepository;


    @Override
    public Void handle(DeleteProductRequest requst) {
        System.out.println("Eliminando producto por id:" + requst.getId() + "....");
        try {
            Thread.sleep(5000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        productRepository.deleteByid(requst.getId());

        System.out.println("Peoducto eliminado con  id:" + requst.getId() + "....");

        return null;
    }

    @Override
    public Class<DeleteProductRequest> getReuestType() {
        return DeleteProductRequest.class;
    }
}
