package com.camilo.webdemo.product.application.comandos.update;

import com.camilo.webdemo.common.Request;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data

public class ProductUpdateRequest implements Request<Void> {
    private Long id;
    private String name;
    private Double precio;
    private String descripcion;
    private MultipartFile file;

}
