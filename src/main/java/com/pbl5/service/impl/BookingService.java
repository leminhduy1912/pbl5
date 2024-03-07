package com.pbl5.service.impl;

import com.pbl5.dao.IBookingDAO;
import com.pbl5.dao.impl.BookingDAO;
import com.pbl5.dtos.BookingDTO;
import com.pbl5.helpers.IDGeneration;
import com.pbl5.helpers.respone.Data;
import com.pbl5.helpers.respone.Message;
import com.pbl5.helpers.respone.Meta;
import com.pbl5.helpers.respone.Response;
import com.pbl5.models.Booking;
import com.pbl5.service.IBookingService;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookingService implements IBookingService {
    private IBookingDAO bookingDAO = new BookingDAO();

    @Override
    public Message createBooking(Booking booking) {
//        System.out.println("id"+booking.get);
       Booking checkSeatExist = bookingDAO.checkStatusSeatByShowTimeId(booking);
       if (checkSeatExist != null){
           Meta meta = new Meta.Builder(HttpServletResponse.SC_CONFLICT).withMessage(Response.FAILED).build();
           return new Message.Builder(meta).build();
       } else {
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
           LocalDateTime now = LocalDateTime.now();
           java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(now);
           booking.setCreatedAt(timestamp);
           String id = IDGeneration.generate();
           booking.setId(id);

           try {
               bookingDAO.createBooking(booking);
               Meta meta = new Meta.Builder(HttpServletResponse.SC_OK).withMessage(Response.CREATED).build();
               return new Message.Builder(meta).build();
           } catch (Exception e) {
               e.printStackTrace();
               Meta meta = new Meta.Builder(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).withMessage(Response.CREATE_FAILED).build();
               return new Message.Builder(meta).build();
           }
       }
    }

    @Override
    public Message findSeatAndStatusByShowTimeId(String showTimeId) {

        try {
            List<Booking> bookings = bookingDAO.findSeatAndStatusByShowTimeId( showTimeId);
            Meta meta = new Meta.Builder(HttpServletResponse.SC_OK).withMessage(Response.SUCCESS).build();
            Data data = new Data.Builder(null).withResults(bookings).build();
            return new Message.Builder(meta).withData(data).build();
        } catch (Exception e) {
            Meta meta = new Meta.Builder(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).withMessage("Internal Server Error").build();
            return new Message.Builder(meta).build();
        }
    }
}
