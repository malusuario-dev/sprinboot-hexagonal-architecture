package com.camilo.webdemo.product.infrastructure.api;

import com.camilo.webdemo.common.application.mediator.Mediator;
import com.camilo.webdemo.product.infrastructure.api.mapper.ProuctMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @Mock
    private Mediator mediator;
    @Mock
    private ProuctMapper prouctMapper;
    @InjectMocks
    private ProductController productController;


    //

}