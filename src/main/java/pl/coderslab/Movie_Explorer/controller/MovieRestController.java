package pl.coderslab.Movie_Explorer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Movie_Explorer.domain.Movie;
import pl.coderslab.Movie_Explorer.domain.MovieGenre;
import pl.coderslab.Movie_Explorer.domain.MovieList;
import pl.coderslab.Movie_Explorer.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {
    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/get")
    public ResponseEntity<MovieList> getMovies(@RequestParam String query) {
        return movieService.getMoviesByQuery(query);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/get/overview/{id}")
    public ResponseEntity<String> getMovieOverviewById(@PathVariable String id) {
        return movieService.getMovieOverviewById(id);
    }

    @GetMapping("/get/genres")
    public ResponseEntity<MovieList> getMoviesByGenres(@RequestParam List<MovieGenre> genres) {
        return movieService.getMoviesByGenres(genres);
    }
}
