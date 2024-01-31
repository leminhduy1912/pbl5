package com.pbl5.dao;

import com.pbl5.models.Movie;

import java.util.List;

public interface IMovieDAO {
    List<Movie> findAllMovieIsShowing();
    void createMovie(Movie movie,String username);
}
