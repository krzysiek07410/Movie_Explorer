package pl.coderslab.Movie_Explorer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.Movie_Explorer.domain.Movie;
import pl.coderslab.Movie_Explorer.domain.MovieGenre;
import pl.coderslab.Movie_Explorer.domain.MovieList;

import java.util.List;


@Service
public class MovieService {
    private final RestTemplate restTemplate;
    @Value("${authorization.header}")
    private final String authorizationHeader;
    private final String url = "https://api.themoviedb.org/3";

    public MovieService(RestTemplate restTemplate, @Value("${authorization.header}") String authorizationHeader) {
        this.restTemplate = restTemplate;
        this.authorizationHeader = authorizationHeader;
    }

    public ResponseEntity<MovieList> getMoviesByQuery(String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader);
        HttpEntity<Movie> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(url + "/search/movie?query=" + query, HttpMethod.GET, requestEntity, MovieList.class);
    }

    public ResponseEntity<Movie> getMovieById(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader);
        HttpEntity<Movie> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(url + "/movie/" + id, HttpMethod.GET, requestEntity, Movie.class);
    }

    public ResponseEntity<String> getMovieOverviewById(String id) {
        return ResponseEntity.ok(getMovieById(id).getBody().getOverview());
    }


    public ResponseEntity<MovieList> getMoviesByGenres(List<MovieGenre> genres) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader);
        HttpEntity<Movie> requestEntity = new HttpEntity<>(headers);

        StringBuilder genresIds = new StringBuilder();
        for (MovieGenre genre : genres)
            genresIds.append(genre.getId()).append("%2C");
        genresIds.delete(genresIds.length() - 3, genresIds.length());

        return restTemplate.exchange(url + "/discover/movie?with_genres=" + genresIds,
                HttpMethod.GET, requestEntity, MovieList.class);
    }
}
