package com.pbl5.dao.impl;

import com.pbl5.dao.IBookingDAO;
import com.pbl5.dtos.BookingDTO;
import com.pbl5.helpers.mapper.BookingMapper;
import com.pbl5.helpers.mapper.GetSeatAndStatusMapper;
import com.pbl5.models.Booking;

import java.util.List;

public class BookingDAO extends AbstractDAO<Booking> implements IBookingDAO {
    @Override
    public void createBooking(Booking booking) {
        String sql="INSERT INTO bookings(bookingId,userId,showtimeId" +
                ",totalAmount,bookingDate,seatId) VALUES(?,?,?,?,?,?)";
            insert(sql, booking.getId(), booking.getUserId(), booking.getShowTimeId(),
                    booking.getTotalAmount(), booking.getBookingDate(), booking.getSeatId());

    }

    @Override
    public List<Booking> findSeatAndStatusByShowTimeId(String showtimeId) {
        String sql="SELECT s.seatNum,b.status FROM bookings as b " +
                "INNER JOIN seats  as s on b.seatId = s.seatId " +
                "WHERE showtimeId=?";
        return query(sql,new GetSeatAndStatusMapper(),showtimeId);
    }

    @Override
    public Booking checkStatusSeatByShowTimeId(Booking booking) {
        String sql="SELECT  seatId,status from bookings WHERE showtimeId=? AND seatId=?";
        List<Booking> results = query(sql,new GetSeatAndStatusMapper(),
                booking.getShowTimeId(),booking.getSeatId());
        return results.isEmpty() ? null: results.get(0);
    }
}
