package com.camilo.webdemo.product.infrastructure.database.entity;


import com.camilo.webdemo.category.infraestructure.CategoryEntity;
import com.camilo.webdemo.productDetail.infrastructure.ProductDetailEntity;
import com.camilo.webdemo.review.infrastructure.ReviewEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "product")
    private List<ReviewEntity> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "productos_categories", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categories = new ArrayList<>();

}
