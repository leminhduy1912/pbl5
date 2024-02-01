package com.pbl5.service;

import com.pbl5.helpers.respone.Message;
import com.pbl5.models.Movie;

public interface IMovieService {
    Message findAllMovieIsShowing();
    Message createMovie(Movie movie,String username);
    Message deleteMovie(String movieId);
    Message updateMovie(Movie movie,String username);
    Message findOneById(String movieId);
}
