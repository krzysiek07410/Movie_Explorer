package pl.coderslab.Movie_Explorer.service;

import org.springframework.stereotype.Service;
import pl.coderslab.Movie_Explorer.domain.FavouriteMovie;
import pl.coderslab.Movie_Explorer.exception.NotFoundContentException;
import pl.coderslab.Movie_Explorer.repository.MovieRepository;

@Service
public class FavouriteMovieService {
    private final MovieRepository movieRepository;

    public FavouriteMovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public FavouriteMovie test() {
        FavouriteMovie favouriteMovie = new FavouriteMovie();
        favouriteMovie.setId(1);
        favouriteMovie.setTitle("Test");
        favouriteMovie.setOverview("Test overview");
        return movieRepository.save(favouriteMovie);
    }

    public FavouriteMovie saveFavouriteMovie(FavouriteMovie favouriteMovie) {
        return movieRepository.save(favouriteMovie);
    }

    public FavouriteMovie getFavouriteMovieById(int id) {
        return movieRepository.findById(id).orElseThrow(() -> new NotFoundContentException("Movie not found"));
    }
}
