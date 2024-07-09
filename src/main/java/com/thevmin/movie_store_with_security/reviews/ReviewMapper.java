package com.thevmin.movie_store_with_security.reviews;

import com.thevmin.movie_store_with_security.movies.Movie;
import com.thevmin.movie_store_with_security.reviews.dto.CreateReviewRequestDTO;
import com.thevmin.movie_store_with_security.reviews.dto.ReviewDTO;
import com.thevmin.movie_store_with_security.user.User;
import com.thevmin.movie_store_with_security.user.UserMapper;

import java.util.List;

public class ReviewMapper {

    public static Review MapCreateReviewRequestDtoToReview(CreateReviewRequestDTO createReviewRequestDTO, User user, Movie movie) {
        return Review.builder()
                .review(createReviewRequestDTO.getReview())
                .reviewedMovie(movie)
                .reviewOwner(user)
                .build();
    }

    public static List<ReviewDTO> MapListOfReviewToListOfReviewDTO(List<Review> reviews) {
        return reviews.stream().map(ReviewMapper::MapReviewToReviewDTO).toList();

    }

    public static ReviewDTO MapReviewToReviewDTO(Review review) {
        return ReviewDTO.builder()
                .id(review.getId())
                .review(review.getReview())
                .owner(UserMapper.MapUserToUserProfileDTO(review.getReviewOwner())).build();
    }
}
