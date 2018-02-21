package com.coviam.booking.controllers;


import com.coviam.booking.dto.BookingDTO;
import com.coviam.booking.dto.BookingDetailsDTO;
import com.coviam.booking.dto.PaymentStatusDTO;
import com.coviam.booking.entity.Booking;
import com.coviam.booking.kafka.storage.MessageStorage;
import com.coviam.booking.service.BookingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    public BookingService bookingService;


    @RequestMapping(
            value = "/createBooking",
            method = RequestMethod.POST,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> createBooking(@RequestBody BookingDTO bookingDTO) {
        BookingDTO newBookingDTO = bookingService.createBooking(bookingDTO);
        return new ResponseEntity<>(newBookingDTO, OK);
    }


    @RequestMapping(
            value = "/superPnr/{superPnr}",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getBooking(@PathVariable("superPnr") String superPnr) {
        BookingDetailsDTO bookingDetailsDTO = bookingService.getBookingDetailsFromSuperPnr(superPnr);
        return new ResponseEntity<>(bookingDetailsDTO, OK);
    }

    @RequestMapping(value = "/updateBookingPayment",
            method = RequestMethod.POST,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> updatePaymentStatus(@RequestBody PaymentStatusDTO paymentStatusDTO) {
        Booking booking = bookingService.getBookingFromSuperPnr((String) paymentStatusDTO.getSuperPnr());
        Booking updatedBooking = bookingService.updateBookingPaymentStatus(paymentStatusDTO,booking);
        BookingDTO bookingDTO =new BookingDTO();
        BeanUtils.copyProperties(updatedBooking,bookingDTO);
        return new ResponseEntity<BookingDTO>(bookingDTO, OK);
    }

    @Autowired
    MessageStorage storage;

    @GetMapping(value="/m/all")
    public String getAllRecievedMessage(){
        String messages = storage.toString();
        return messages;
    }
}
