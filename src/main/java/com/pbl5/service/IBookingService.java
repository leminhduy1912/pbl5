package com.pbl5.service;

import com.pbl5.helpers.respone.Message;
import com.pbl5.models.Booking;

import java.util.List;

public interface IBookingService {
    Message createBooking(Booking booking);
    Message findSeatAndStatusByShowTimeId(String showTimeId);
}
