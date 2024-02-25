package com.pbl5.service;

import com.pbl5.helpers.respone.Message;
import com.pbl5.models.ShowTime;

public interface IShowTimeService {
    Message findByMovieIdAndDateShow(String movieId,String dateShow);
    Message createShowTime(ShowTime showTime,String username);
}
