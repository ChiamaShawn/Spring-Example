package com.ics.demo.groupAspring;


import com.ics.demo.groupAspring.models.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import sun.tools.jar.CommandLine;

import java.util.List;

@Component
public class TestingRestGroupA implements CommandLineRunner {
    public void run(String ...args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Movie>> response = restTemplate.exchange(
                 "http://10.51.10.111:9090/movies",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Movie>>(){});
        List<Movie> movies = response.getBody();
        System.out.println(movies.toString());
        Movie movie = restTemplate.getForObject("http://10.51.10.111:9090/movies/3", Movie.class);
        System.err.println(movie.toString());
    }

}
