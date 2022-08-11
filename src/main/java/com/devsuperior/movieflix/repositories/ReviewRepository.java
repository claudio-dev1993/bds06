package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    @Query(nativeQuery = true, value = "SELECT * FROM TB_REVIEW WHERE TB_REVIEW.MOVIE_ID =:id" )
    List<Review> findReviewList(Long id);
}
