package com.pbl5.helpers.mapper;

import com.pbl5.models.ShowTime;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowTimeMapper implements IMapper<ShowTime>{
    @Override
    public ShowTime mapRow(ResultSet result) throws SQLException {
        ShowTime showTime = new ShowTime();
        showTime.setMovieId(result.getString("movieId"));
        showTime.setTheaterName("theaterName");
        showTime.setTheaterId("theaterId");
        showTime.setTimeEnd(result.getString("timeEnd"));
        showTime.setTimeStart(result.getString("timeStart"));
        showTime.setDateShow(result.getString("date_show"));
        showTime.setId(result.getString("showtimeId"));
        return showTime;
    }
}
