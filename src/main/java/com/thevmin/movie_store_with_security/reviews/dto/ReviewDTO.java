package com.thevmin.movie_store_with_security.reviews.dto;

import com.thevmin.movie_store_with_security.user.dto.UserProfileDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Long id;

    private String review;

    private UserProfileDTO owner;
}
