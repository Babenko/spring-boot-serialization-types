package com.demo.serialization.movie.controller;

import com.demo.serialization.common.model.Movie;
import com.demo.serialization.common.model.Movies;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class MovieController {


    @GetMapping(path = "/movie", produces = {"application/json", "application/octet-stream"})
    public Movies movies() {
        return getMovies();
    }

    @GetMapping(path = "/list", produces = {"application/json", "application/octet-stream"})
    public List<Movie> moviesList() {
        Movies movies = getMovies();
        System.out.println(movies);
        return movies.getMovies();
    }

    private Movies getMovies() {
        Movies movies = new Movies();
        ArrayList<Movie> list = new ArrayList<>();
        Instant now = Instant.now();
        Date release = Date.from(now);
        list.add(new Movie(now, release, UUID.randomUUID(), "AVG1"));
        list.add(new Movie(now, release, UUID.randomUUID(), "AVG2"));
        list.add(new Movie(now, release, UUID.randomUUID(), "AVG3"));
        list.add(new Movie(now, release, UUID.randomUUID(), "AVG4"));
        list.add(new Movie(now, release, UUID.randomUUID(), "AVG5"));
        movies.setMovies(list);
        return movies;
    }
}
