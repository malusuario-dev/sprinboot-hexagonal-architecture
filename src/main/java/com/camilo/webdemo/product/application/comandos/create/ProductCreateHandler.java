package com.camilo.webdemo.product.application.comandos.create;

import com.camilo.webdemo.common.application.mediator.RequestHandler;
import com.camilo.webdemo.common.infrastriture.util.FileUtils;
import com.camilo.webdemo.product.domain.entity.Producto;
import com.camilo.webdemo.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCreateHandler implements RequestHandler<ProductCreateRequest, ProductCreateResponse> {

    private final ProductRepository productRepository;
    private final FileUtils fileUtils;


    @Override
    public ProductCreateResponse handle(ProductCreateRequest requst) {
        String uniqueFile = fileUtils.getUniqueFile(requst.getFile());
        log.info("Creating product");
        Producto producto = Producto.builder().
                name(requst.getName())
                .descripcion(requst.getDescripcion()).
                image(uniqueFile)
                .precio(requst.getPrecio()).build();
        Producto productstar = productRepository.upsert(producto);

        log.info("Created product with id {}", productstar.getId());
        return new ProductCreateResponse(productstar);
    }

    @Override
    public Class<ProductCreateRequest> getReuestType() {
        return ProductCreateRequest.class;
    }
}
