package com.camilo.webdemo.review.infrastructure;

import com.camilo.webdemo.product.infrastructure.database.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reviews")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rating;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductEntity product;


}
