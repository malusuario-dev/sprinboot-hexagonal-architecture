package com.camilo.webdemo.product.infrastructure.api.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class UpdateProuctDto {

    private Long id;
    @NotBlank
    private String name;
    @DecimalMin(value = "0.01", inclusive = false)
    @DecimalMax(value = "999.99", inclusive = false)
    private Double precio;
    @Length(min = 10, max = 200, message = "la cantidad de caractares son minimo 10 maximo 250 ")
    private String descripcion;
    private String provider;
    private ReviewDto review;
    private Long category;
}
