package com.ics.demo.groupAspring.service;

import com.ics.demo.groupAspring.models.Actor;
import com.ics.demo.groupAspring.models.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(Long id);
    Movie create (Movie  movie);
    Movie update (Movie movie);
    void createActor (Long id, Actor actor);
    Movie update( Long id, Movie movie);
    void delete(Long id);
}
