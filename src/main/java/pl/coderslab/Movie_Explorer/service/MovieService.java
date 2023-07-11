package pl.coderslab.Movie_Explorer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.Movie_Explorer.domain.Movie;
import pl.coderslab.Movie_Explorer.domain.MovieList;


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
}
