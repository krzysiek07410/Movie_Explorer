package pl.coderslab.Movie_Explorer.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public class FavouriteMovie extends Movie {
    //in the future I will add users to this class
    public FavouriteMovie() {
    }

    public FavouriteMovie(boolean adult, String backdrop_path, int[] genre_ids, int id, String original_language,
                          String original_title, String overview, double popularity, String poster_path,
                          String release_date, String title, boolean video, double vote_average, int vote_count) {
        super(adult, backdrop_path, genre_ids, id, original_language, original_title, overview, popularity,
                poster_path, release_date, title, video, vote_average, vote_count);
    }
}
