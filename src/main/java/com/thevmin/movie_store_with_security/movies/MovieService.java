package com.thevmin.movie_store_with_security.movies;

import com.thevmin.movie_store_with_security.movies.dto.MovieCardResponseDTO;
import com.thevmin.movie_store_with_security.movies.dto.MovieResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieCardResponseDTO> findAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(MovieMapper::mapMovieToMovieCardResponseDTO)
                .collect(Collectors.toList());
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public ResponseEntity<MovieResponseDTO> getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()){
            return new ResponseEntity<>(MovieMapper.mapMovieToMovieResponseDTO(movie.get()), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
