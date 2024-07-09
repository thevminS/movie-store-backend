package com.thevmin.movie_store_with_security.reviews.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewRequestDTO {
    private String review;
    private Long userId;
    private Long movieId;
}
