package com.devsuperior.movieflix.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT DISTINCT obj FROM Movie obj INNER JOIN obj.genre gen WHERE obj.id =:id")
    Optional<Movie> findMovieById(Long id);

    @Query("SELECT DISTINCT obj FROM Movie obj INNER JOIN obj.genre ORDER BY obj.title")
    Page<Movie> findByGenreOrdered(Genre genre, Pageable pageable);

    @Query("SELECT DISTINCT obj FROM Movie obj INNER JOIN obj.genre gen WHERE gen.id =:genreId ORDER BY obj.title")
    Page<Movie> findByGenreId(Long genreId, Genre genre, Pageable pageable);
}
