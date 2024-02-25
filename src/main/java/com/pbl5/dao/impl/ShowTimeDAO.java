package com.pbl5.dao.impl;


import com.pbl5.dao.IShowTimeDAO;
import com.pbl5.helpers.mapper.ShowTimeMapper;
import com.pbl5.models.ShowTime;

import java.sql.Time;
import java.sql.Timestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ShowTimeDAO extends AbstractDAO<ShowTime> implements IShowTimeDAO {
    @Override
    public List<ShowTime> getShowTimeByMovieIdAndDate(String movieId, String dateShow) {

        String sql = "SELECT * FROM showtimes WHERE movieId = ? AND date_show = ?";
        return query(sql, new ShowTimeMapper(), movieId, dateShow);

    }

    @Override
    public void createShowTime(ShowTime showTime,String username) {

        String sql="INSERT INTO showtimes(showtimeId,movieId,theaterId,startTime,endTime,date_show,status,createdAt,createdBy) " +
                "VALUES(?,?,?,?,?,?,?,?,?)";
        insert(sql,showTime.getId(),showTime.getMovieId(),showTime.getTheaterId(),showTime.getTimeStart()
                ,showTime.getTimeEnd(),showTime.getDateShow(),1,showTime.getCreatedAt(),username);
    }
}
