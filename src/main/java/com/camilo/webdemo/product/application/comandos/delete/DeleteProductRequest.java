package com.camilo.webdemo.product.application.comandos.delete;

import com.camilo.webdemo.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class DeleteProductRequest implements Request<Void> {
    private Long id;
}