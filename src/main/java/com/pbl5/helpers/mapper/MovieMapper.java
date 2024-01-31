package com.pbl5.helpers.mapper;

import com.pbl5.models.Movie;
import com.pbl5.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements IMapper<Movie>{
    @Override
    public Movie mapRow(ResultSet result) {
        Movie movie = new Movie();
        try {
            movie.setId(result.getString("movie_id"));
            movie.setDescription(result.getString("description"));
            movie.setMoviePoster(result.getString("poster"));
            movie.setActive(result.getInt("active"));
            movie.setKindId(result.getInt("kind_id"));
            movie.setKindName(result.getString("genre_name"));
            movie.setDuration(result.getInt("duration"));
            movie.setReleaseDate(result.getLong("release_date"));
            return movie;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            return null;
        }
    }
}
