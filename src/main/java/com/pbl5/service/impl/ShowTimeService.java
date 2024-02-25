package com.pbl5.service.impl;


import com.pbl5.dao.IShowTimeDAO;
import com.pbl5.dao.impl.ShowTimeDAO;
import com.pbl5.helpers.IDGeneration;
import com.pbl5.helpers.respone.Data;
import com.pbl5.helpers.respone.Message;
import com.pbl5.helpers.respone.Meta;
import com.pbl5.helpers.respone.Response;
import com.pbl5.models.ShowTime;
import com.pbl5.service.IShowTimeService;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class    ShowTimeService implements IShowTimeService {
    private IShowTimeDAO showTimeDAO = new ShowTimeDAO();
    @Override
    public Message findByMovieIdAndDateShow(String movieId, String dateShow) {
        List<ShowTime> result = showTimeDAO.getShowTimeByMovieIdAndDate(movieId, dateShow);
        Meta meta = new Meta.Builder(HttpServletResponse.SC_OK).withMessage(Response.SUCCESS).build();
        Data data = new Data.Builder(null).withResults(result).build();
        return new Message.Builder(meta).withData(data).build();

    }

    @Override
    public Message createShowTime(ShowTime showTime, String username) {

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(now);
            showTime.setCreatedAt(timestamp);


            String id = IDGeneration.generate();
            showTime.setId(id);
           showTimeDAO.createShowTime(showTime,username);
            Meta meta = new Meta.Builder(HttpServletResponse.SC_OK).withMessage(Response.CREATED).build();
            return new Message.Builder(meta).build();
        } catch(Exception e){
            Meta meta = new Meta.Builder(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).withMessage("Internal Server Error").build();
            return new Message.Builder(meta).build();
        }

    }
}
