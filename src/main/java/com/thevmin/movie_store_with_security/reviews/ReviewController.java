package com.thevmin.movie_store_with_security.reviews;

import com.thevmin.movie_store_with_security.configurations.Constants;
import com.thevmin.movie_store_with_security.reviews.dto.CreateReviewRequestDTO;
import com.thevmin.movie_store_with_security.reviews.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(Constants.REVIEW_URL)
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<String> addReview(@RequestBody CreateReviewRequestDTO createReviewRequestDTO){
        return reviewService.createReview(createReviewRequestDTO);
    }
}
