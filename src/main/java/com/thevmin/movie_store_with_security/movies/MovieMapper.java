package com.thevmin.movie_store_with_security.movies;

import com.thevmin.movie_store_with_security.movies.dto.MovieCardResponseDTO;
import com.thevmin.movie_store_with_security.movies.dto.MovieResponseDTO;
import com.thevmin.movie_store_with_security.reviews.ReviewMapper;

public class MovieMapper {
    public static MovieCardResponseDTO mapMovieToMovieCardResponseDTO(Movie movie){
        return MovieCardResponseDTO.builder()
                .id(movie.getId())
                .name(movie.getName())
                .description(movie.getDescription())
                .coverImageLink(movie.getCoverImageLink())
                .rating(movie.getRating())
                .build();
    }

    public static MovieResponseDTO mapMovieToMovieResponseDTO(Movie movie){
        return MovieResponseDTO.builder()
                .id(movie.getId())
                .coverImageLink(movie.getCoverImageLink())
                .description(movie.getDescription())
                .director(movie.getDirector())
                .language(movie.getLanguage())
                .name(movie.getName())
                .rating(movie.getRating())
                .releaseDate(movie.getReleaseDate())
                .tailorLink(movie.getTailorLink())
                .reviews(ReviewMapper.MapListOfReviewToListOfReviewDTO(movie.getMovieReviews())).build();
    }
}
