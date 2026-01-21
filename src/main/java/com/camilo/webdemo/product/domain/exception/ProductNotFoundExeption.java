package com.camilo.webdemo.product.domain.exception;

public class ProductNotFoundExeption extends RuntimeException {
    public ProductNotFoundExeption(Long id) {
        super(" el producto con el id: "+ id +"no se encuentra ");
    }
}
