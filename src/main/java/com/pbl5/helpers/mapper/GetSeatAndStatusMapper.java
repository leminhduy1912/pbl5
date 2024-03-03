package com.pbl5.helpers.mapper;

import com.pbl5.models.Booking;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetSeatAndStatusMapper implements IMapper<Booking>{

    @Override
    public Booking mapRow(ResultSet result) throws SQLException {
        Booking booking = new Booking();


        booking.setSeatName(result.getString("seatNum"));
        booking.setStatus(result.getString("status"));

        return booking;
    }
}
