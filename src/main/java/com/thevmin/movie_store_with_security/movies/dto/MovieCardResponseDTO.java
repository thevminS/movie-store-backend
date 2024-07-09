package com.thevmin.movie_store_with_security.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieCardResponseDTO {
    private Long id;

    private String name;

    private String description;

    private String rating;

    private String coverImageLink;
}
