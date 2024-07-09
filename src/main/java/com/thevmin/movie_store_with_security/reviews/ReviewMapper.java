package com.thevmin.movie_store_with_security.reviews;

import com.thevmin.movie_store_with_security.movies.Movie;
import com.thevmin.movie_store_with_security.reviews.dto.CreateReviewRequestDTO;
import com.thevmin.movie_store_with_security.reviews.dto.ReviewDTO;
import com.thevmin.movie_store_with_security.user.User;
import com.thevmin.movie_store_with_security.user.UserMapper;

import java.util.List;

public class ReviewMapper {

    private ReviewMapper(){
        throw new IllegalStateException("Utility class");
    }

    public static Review mapCreateReviewRequestDtoToReview(CreateReviewRequestDTO createReviewRequestDTO, User user, Movie movie) {
        return Review.builder()
                .reviewText(createReviewRequestDTO.getReview())
                .reviewedMovie(movie)
                .reviewOwner(user)
                .build();
    }

    public static List<ReviewDTO> mapListOfReviewToListOfReviewDTO(List<Review> reviews) {
        return reviews.stream().map(ReviewMapper::mapReviewToReviewDTO).toList();

    }

    public static ReviewDTO mapReviewToReviewDTO(Review review) {
        return ReviewDTO.builder()
                .id(review.getId())
                .review(review.getReviewText())
                .owner(UserMapper.mapUserToUserProfileDTO(review.getReviewOwner())).build();
    }
}
