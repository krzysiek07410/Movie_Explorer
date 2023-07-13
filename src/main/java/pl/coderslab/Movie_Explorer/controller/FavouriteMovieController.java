package pl.coderslab.Movie_Explorer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Movie_Explorer.domain.FavouriteMovie;
import pl.coderslab.Movie_Explorer.service.FavouriteMovieService;

@RestController
@RequestMapping("/api/movies/favourite")
public class FavouriteMovieController {
    private final FavouriteMovieService favouriteMovieService;

    public FavouriteMovieController(FavouriteMovieService favouriteMovieService) {
        this.favouriteMovieService = favouriteMovieService;
    }

    @GetMapping("/test")
    public ResponseEntity<FavouriteMovie> test() {
        return ResponseEntity.ok(favouriteMovieService.test());
    }

    @PostMapping("/save")
    public ResponseEntity<FavouriteMovie> saveFavouriteMovie(@RequestBody FavouriteMovie favouriteMovie) {
        return ResponseEntity.ok(favouriteMovieService.saveFavouriteMovie(favouriteMovie));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<FavouriteMovie> getFavouriteMovieById(@PathVariable int id) {
        return ResponseEntity.ok(favouriteMovieService.getFavouriteMovieById(id));
    }
}
