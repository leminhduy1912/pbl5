package com.pbl5.service.impl;

import com.pbl5.dao.IMovieDAO;
import com.pbl5.dao.impl.MovieDAO;
import com.pbl5.helpers.IDGeneration;
import com.pbl5.helpers.respone.Data;
import com.pbl5.helpers.respone.Message;
import com.pbl5.helpers.respone.Meta;
import com.pbl5.helpers.respone.Response;
import com.pbl5.models.Movie;
import com.pbl5.models.User;
import com.pbl5.service.IMovieService;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MovieService implements IMovieService {
    private IMovieDAO iMovieDAO = new MovieDAO();
    @Override
    public Message findAllMovieIsShowing() {
        List<Movie> results = iMovieDAO.findAllMovieIsShowing();
        Meta meta = new Meta.Builder(HttpServletResponse.SC_OK).withMessage(Response.SUCCESS).build();
        Data data = new Data.Builder(null).withResults(results).build();
        return new Message.Builder(meta).withData(data).build();
    }

    @Override
    public Message createMovie(Movie movie, String username) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(now);
        movie.setCreatedAt(timestamp);
        String id = IDGeneration.generate();
        movie.setId(id);
        try {
           iMovieDAO.createMovie(movie,username);
            Meta meta = new Meta.Builder(HttpServletResponse.SC_OK).withMessage(Response.CREATED).build();
            return new Message.Builder(meta).build();

        } catch (Exception e){
            e.printStackTrace();
            Meta meta = new Meta.Builder(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).withMessage(Response.CREATE_FAILED).build();
            return new Message.Builder(meta).build();

        }

    }
}
