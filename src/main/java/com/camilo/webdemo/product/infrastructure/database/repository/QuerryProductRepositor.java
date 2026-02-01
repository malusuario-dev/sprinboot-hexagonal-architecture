package com.camilo.webdemo.product.infrastructure.database.repository;

import com.camilo.webdemo.product.infrastructure.database.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuerryProductRepositor extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {

//    Optional<ProductEntity> finByNameContaining(String name);
//
//    List<ProductEntity> findAllPriceBetween(Double priceAfter, Double priceBefore);

    @Query("""
                SELECT p
                FROM ProductEntity p
                WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))
                  AND p.precio BETWEEN :minPrice AND :maxPrice
                  AND p.descripcion IS NOT NULL
                  AND p.descripcion <> ''
            """
    )
    List<ProductEntity> findProductsNative(
            @Param("name") String name,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("descripcion") String descripcion
    );

    Page<ProductEntity> findAll(Specification<ProductEntity> specification, Pageable pageable);

    @EntityGraph(attributePaths = {"productDetailEntity", "reviews"})
    Optional<ProductEntity> findById(Long id);
}
