package com.chalabookkaru.shows.client;

import com.chalabookkaru.shows.dto.MovieResponse;
import com.chalabookkaru.shows.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class MovieServiceClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public Long getMovieIdByTitle(String title) {
        try {
            ResponseEntity<MovieResponse> response = restTemplate.getForEntity(
                    "http://localhost:8082/movies/title/" + title,
                    MovieResponse.class);
            return Objects.requireNonNull(response.getBody()).getMovieId();
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new MovieNotFoundException(
                        "Movie not found in Movie Service for title: " + title, HttpStatus.NOT_FOUND
                );
            }
            throw ex;
        }
    }
}
