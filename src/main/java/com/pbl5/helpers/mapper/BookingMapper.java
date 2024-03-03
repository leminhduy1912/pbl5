package com.pbl5.helpers.mapper;

import com.pbl5.dtos.BookingDTO;
import com.pbl5.models.Booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingMapper implements IMapper<Booking>{
    @Override
    public Booking mapRow(ResultSet result) throws SQLException {
        Booking booking = new Booking();

        booking.setShowTimeId(result.getString("showtimeId"));
        booking.setUserId(result.getString("userId"));
        booking.setSeatId(result.getString("seatId"));
        booking.setSeatName(result.getString("seatNum"));
        booking.setStatus("status");
        booking.setTotalAmount(result.getInt("amount"));
        booking.setBookingDate(result.getString("bookingDate"));
        booking.setId(result.getString("bookingId"));
        booking.setMovieName(result.getString("movieName"));
        booking.setSeatName(result.getString("seatName"));
        return booking;
    }
}
