package com.devsuperior.movieflix.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    @Query(nativeQuery = true, value = "SELECT * FROM TB_MOVIE INNER JOIN TB_GENRE ON TB_MOVIE.ID = TB_GENRE.ID WHERE TB_MOVIE.ID = :id")
    Optional<Movie> findMovieById (Long id);
}
