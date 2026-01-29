package com.camilo.webdemo.product.application.comandos.create;

import com.camilo.webdemo.common.application.mediator.Request;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data

public class ProductCreateRequest implements Request<ProductCreateResponse> {
    private String name;
    private Double precio;
    private String descripcion;
    private MultipartFile file;

}
