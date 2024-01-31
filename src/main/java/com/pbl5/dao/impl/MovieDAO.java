package com.pbl5.dao.impl;

import com.pbl5.dao.GenericDAO;
import com.pbl5.dao.IMovieDAO;
import com.pbl5.helpers.TimestampConvert;
import com.pbl5.helpers.mapper.MovieMapper;
import com.pbl5.helpers.mapper.UserMapper;
import com.pbl5.models.Movie;

import java.util.List;
import java.util.logging.Logger;

public class MovieDAO extends AbstractDAO<Movie> implements IMovieDAO {
    private static final Logger logger = Logger.getLogger("MovieDAO");
    @Override
    public List<Movie> findAllMovieIsShowing() {
        logger.info("Find all movie is showing");
        String sql = "SELECT * FROM movies AS M INNER JOIN kindofmovie AS G ON M.kind_id = G.kind_id  " +
                " WHERE M.active = 1 ";
        return query(sql, new MovieMapper());
    }

    @Override
    public void createMovie(Movie movie, String username) {

        logger.info("Create movie");
        String sql="INSERT INTO movies (movie_id,title,kind_id,release_date," +
                "duration,description,active,poster,createdBy,createdAt) VALUES (?,?,?,?,?,?,?,?,?,?)";
        insert(sql,movie.getId(),movie.getTitle(),movie.getKindId(),TimestampConvert.convert(movie.getReleaseDate())
                ,movie.getDuration(),movie.getDescription(),1,movie.getMoviePoster(),username,movie.getCreatedAt());
    }
}
