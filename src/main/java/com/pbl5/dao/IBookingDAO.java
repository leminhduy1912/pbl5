package com.pbl5.dao;

import com.pbl5.dtos.BookingDTO;
import com.pbl5.models.Booking;

import java.util.List;

public interface IBookingDAO {
    void createBooking(Booking booking);
    List<Booking> findSeatAndStatusByShowTimeId(String showtimeId);
}
