package com.camilo.webdemo.product.infrastructure.api.dto;

import lombok.Data;

@Data
public class ReviewDto {

    private Long id;
    private Integer rating;
    private String comment;
}
