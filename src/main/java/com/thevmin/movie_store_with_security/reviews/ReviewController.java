package com.thevmin.movie_store_with_security.reviews;

import com.thevmin.movie_store_with_security.configurations.Constants;
import com.thevmin.movie_store_with_security.reviews.dto.CreateReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequiredArgsConstructor
@RequestMapping(Constants.REVIEW_URL)
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<String> addReview(@RequestBody CreateReviewRequestDTO createReviewRequestDTO) {
        return reviewService.createReview(createReviewRequestDTO);
    }
}
