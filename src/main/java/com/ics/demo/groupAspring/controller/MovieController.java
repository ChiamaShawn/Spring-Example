package com.ics.demo.groupAspring.controller;

import com.ics.demo.groupAspring.models.Actor;
import com.ics.demo.groupAspring.models.Movie;
import com.ics.demo.groupAspring.service.ActorService;
import com.ics.demo.groupAspring.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "movies", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class MovieController {
    private final MovieService movieService;
//    private final ActorService actorService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findAll(){
        return movieService.findAll();
    }

    @GetMapping(value = "{id}")
    public Movie findById(@PathVariable Long id){
        return movieService.findById(id);
    }

    @PostMapping
    public Movie create(@Validated({Movie.Create.class}) @RequestBody Movie movie){
        return movieService.create(movie);
    }
    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id){
        movieService.delete(id);
    }

    @PatchMapping
    public Movie update(@Validated({Movie.Update.class}) @RequestBody Movie movie){
        return movieService.update(movie);
    }

    @PatchMapping(value="{id}")
    public Movie update(@Validated({Movie.Update.class}) @PathVariable Long id, @RequestBody Movie movie){
        return movieService.update(id,movie);
    }
}
