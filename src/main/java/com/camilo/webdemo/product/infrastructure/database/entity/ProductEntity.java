package com.camilo.webdemo.product.infrastructure.database.entity;


import com.camilo.webdemo.productDetail.infrastructure.ProductDetailEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

@Table(name = "producto")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double precio;
    @Column(length = 500)
    private String descripcion;
    private String image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_detail_id")
    private ProductDetailEntity productDetailEntity;

}
