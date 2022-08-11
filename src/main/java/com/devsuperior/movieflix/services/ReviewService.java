package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    @Transactional
    public ReviewDTO insertReview(ReviewDTO dto) {
        Movie movie = (dto.getMovieId() == 0 ) ? null : movieRepository.getOne(dto.getMovieId());
        User user = userRepository.getOne(authService.authenticated().getId());
        Review review = new Review();

        review.setText(dto.getText());
        review.setMovie(movie);
        review.setUser(user);
        review = reviewRepository.save(review);

        return new ReviewDTO(review);
    }

    @Transactional(readOnly = true)
    public List<ReviewDTO> findMovieReview(Long id) {
        List<Review> list = reviewRepository.findReviewList(id);
        return list.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
    }

    
}
