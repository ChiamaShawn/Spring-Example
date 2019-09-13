package com.ics.demo.groupAspring;

import com.ics.demo.groupAspring.models.Actor;
import com.ics.demo.groupAspring.models.Category;
import com.ics.demo.groupAspring.models.Movie;
import com.ics.demo.groupAspring.repositories.ActorRepository;
import com.ics.demo.groupAspring.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class DummyData implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    public DummyData(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category("Science Fiction");
        Category category1 = new Category("Thriller");
        Set<Category> categories = new HashSet<>();
        categories.add(category);

        ArrayList<Movie> movieList = new ArrayList<Movie>();
//        movieList.add(new Movie("Fast and Slow", "1990", categories.s));
//        movieList.add(new Movie("Slow and Fast", "1989"));


        movieRepository.saveAll(movieList);

    }
}
