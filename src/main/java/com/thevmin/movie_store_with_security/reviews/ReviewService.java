package com.thevmin.movie_store_with_security.reviews;

import com.thevmin.movie_store_with_security.movies.Movie;
import com.thevmin.movie_store_with_security.movies.MovieRepository;
import com.thevmin.movie_store_with_security.reviews.dto.CreateReviewRequestDTO;
import com.thevmin.movie_store_with_security.user.User;
import com.thevmin.movie_store_with_security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public ResponseEntity<String> createReview(CreateReviewRequestDTO createReviewRequestDTO) {
        User user = userRepository.findById(createReviewRequestDTO.getUserId()).orElseThrow();
        Movie movie = movieRepository.findById(createReviewRequestDTO.getMovieId()).orElseThrow();
        reviewRepository.save(ReviewMapper.mapCreateReviewRequestDtoToReview(createReviewRequestDTO, user, movie));
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }


}
