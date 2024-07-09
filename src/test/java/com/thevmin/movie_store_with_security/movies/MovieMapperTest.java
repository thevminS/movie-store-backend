package com.thevmin.movie_store_with_security.movies;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieMapperTest {
    Movie movie = new Movie();

    @BeforeEach
    void setUp() {
        movie.setId((long) 5);
        movie.setName("Avengers");
        movie.setDescription("Avengers");
        movie.setCoverImageLink("http://avengers.com/avengers.jpg");
        movie.setRating("86.56%");
    }

    @Test
    void testWhetherIdEquals() {
        assertEquals(movie.getId(), MovieMapper.mapMovieToMovieCardResponseDTO(movie).getId());
    }

    @Test
    void testWhetherNameEquals() {
        assertEquals(movie.getName(), MovieMapper.mapMovieToMovieCardResponseDTO(movie).getName());
    }

    @Test
    void testWhetherDescriptionEquals() {
        assertEquals(movie.getDescription(), MovieMapper.mapMovieToMovieCardResponseDTO(movie).getDescription());
    }

    @Test
    void testWhetherLinkEquals() {
        assertEquals(movie.getCoverImageLink(), MovieMapper.mapMovieToMovieCardResponseDTO(movie).getCoverImageLink());
    }

    @Test
    void testWhetherRatingEquals() {
        assertEquals(movie.getRating(), MovieMapper.mapMovieToMovieCardResponseDTO(movie).getRating());
    }

}