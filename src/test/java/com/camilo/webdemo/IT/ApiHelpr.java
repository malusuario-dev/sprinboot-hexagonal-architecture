package com.camilo.webdemo.IT;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class ApiHelpr {

    @Bean
    public TestRestTemplate getRestTemplate(){
    return  new TestRestTemplate(new
            RestTemplateBuilder().
            basicAuthentication("spring","spring")
            .connectTimeout(java.time.Duration.ofSeconds(10)));
    }
}
