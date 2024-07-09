package com.thevmin.movie_store_with_security.movies.dto;
import com.thevmin.movie_store_with_security.reviews.dto.ReviewDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDTO {
    private Long id;

    private String name;

    private String description;

    private String rating;

    private String director;

    private String language;

    private String releaseDate;

    private String coverImageLink;

    private String tailorLink;

    private List<ReviewDTO> reviews;
}
