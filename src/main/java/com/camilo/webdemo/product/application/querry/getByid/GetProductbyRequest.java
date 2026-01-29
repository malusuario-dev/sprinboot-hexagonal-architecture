package com.camilo.webdemo.product.application.querry.getByid;

import com.camilo.webdemo.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProductbyRequest implements Request<GetProductByidResponse> {
    private Long id;
}
