package com.camilo.webdemo.review.infrastructure.repo;

import com.camilo.webdemo.review.infrastructure.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuerryProductReviewsRepo extends JpaRepository<ReviewEntity, Long> {

}
