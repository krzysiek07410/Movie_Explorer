package pl.coderslab.Movie_Explorer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.coderslab.Movie_Explorer.domain.FavouriteMovie;

public interface MovieRepository extends MongoRepository<FavouriteMovie, Integer> {

}
