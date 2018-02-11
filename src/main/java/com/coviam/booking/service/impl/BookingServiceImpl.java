package com.coviam.booking.service.impl;

import com.coviam.booking.dto.PaymentStatusDTO;
import com.coviam.booking.entity.Booking;
import com.coviam.booking.repository.BookingRepository;
import com.coviam.booking.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class BookingServiceImpl implements BookingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);
    @Autowired
    BookingRepository bookingRepository;

    /**
     * GET A SINGLE BOOKING
     *
     * @param id : ID OF THE BOOKING
     * @return : BOOKING OBJECT
     */
    @Override
    public Booking getBookingFromId(String id) {
        Booking booking = bookingRepository.findOne(id);
        LOGGER.info("for id : " + id + " : " + booking);
        return booking;
    }

    /**
     * GET A SINGLE BOOKING
     *
     * @param superPnr : ID OF THE BOOKING
     * @return : BOOKING OBJECT
     */
    @Override
    public Booking getBookingFromSuperPnr(String superPnr) {
        Booking booking = bookingRepository.findBySuperPnr(superPnr);
        LOGGER.info("for superPnr : " + superPnr + " : " + booking);
        return booking;
    }

    /**
     * INSERT A NEW BOOKING IN BOOKING TABLE
     *
     * @param booking : DATA RECEIVED FROM FRONT END TO BE INSERTED
     * @return : THE DTO THAT WAS PASSED
     */
    @Override
    public Booking createBooking(Booking booking) {
        Booking bookingCreated = bookingRepository.save(booking);
        LOGGER.info("inserted : " + bookingCreated);
        return bookingCreated;
    }

    /**
     * UPDATE THE STATUS OF BOOKING THAT IS REFERENCED BY BOOKING ID
     *
     * @param paymentStatusDTO : DTO RECEIVED FROM CALLER
     * @param booking
     * @return : THE SAME DTO OBJECT THAT WAS PASSED
     */
    @Override
    @Transactional
    public Booking updateBookingPaymentStatus(PaymentStatusDTO paymentStatusDTO, Booking booking) {
        booking.setPaymentStatus(paymentStatusDTO.getStatus());
        booking.setBookingStatus(paymentStatusDTO.getStatus());
        booking.setPaymentId(paymentStatusDTO.getPaymentid());
        Booking updatedBooking = bookingRepository.save(booking);
        return updatedBooking;
    }


}
