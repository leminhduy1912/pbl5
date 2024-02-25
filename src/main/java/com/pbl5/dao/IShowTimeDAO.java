package com.pbl5.dao;

import com.pbl5.models.ShowTime;
import com.pbl5.service.impl.ShowTimeService;

import java.util.List;

public interface IShowTimeDAO {
     List<ShowTime> getShowTimeByMovieIdAndDate(String movieId, String dateShow);
     void  createShowTime(ShowTime showTime,String username );
}
