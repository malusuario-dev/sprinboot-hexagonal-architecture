package com.camilo.webdemo.product.application.comandos.update;

import com.camilo.webdemo.common.application.mediator.RequestHandler;
import com.camilo.webdemo.common.infrastriture.util.FileUtils;
import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductUpdateHandler implements RequestHandler<ProductUpdateRequest, Void> {

    private final ProductRepository productRepository;
    private final FileUtils fileUtils;

    @Override
    public Void handle(ProductUpdateRequest requst) {
        String uniqueFile = fileUtils.getUniqueFile(requst.getFile());
        Producto producto = Producto.builder().
                name(requst.getName())
                .descripcion(requst.getDescripcion()).
                image(uniqueFile)
                .precio(requst.getPrecio()).id(requst.getId()).build();
        productRepository.upsert(producto);
        return null;
    }


    @Override
    public Class<ProductUpdateRequest> getReuestType() {
        return ProductUpdateRequest.class;
    }
}
