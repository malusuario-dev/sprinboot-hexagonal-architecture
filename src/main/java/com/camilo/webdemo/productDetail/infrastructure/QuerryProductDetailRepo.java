package com.camilo.webdemo.productDetail.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuerryProductDetailRepo extends JpaRepository<ProductDetailEntity, Long> {

}
