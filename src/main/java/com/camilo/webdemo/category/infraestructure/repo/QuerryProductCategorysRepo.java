package com.camilo.webdemo.category.infraestructure.repo;

import com.camilo.webdemo.category.infraestructure.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuerryProductCategorysRepo extends JpaRepository<CategoryEntity, Long> {

}
