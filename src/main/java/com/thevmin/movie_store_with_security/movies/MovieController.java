package com.thevmin.movie_store_with_security.movies;

import com.thevmin.movie_store_with_security.configurations.Constants;
import com.thevmin.movie_store_with_security.movies.dto.MovieCardResponseDTO;
import com.thevmin.movie_store_with_security.movies.dto.MovieResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(Constants.MOVIE_URL)
public class MovieController {

    private final MovieService movieService;

    @CrossOrigin
    @GetMapping
    ResponseEntity<List<MovieCardResponseDTO>> getAll() {
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.FOUND);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void addMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
    }

}
