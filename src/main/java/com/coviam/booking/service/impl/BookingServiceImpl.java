package com.coviam.booking.service.impl;

import com.coviam.booking.dto.*;
import com.coviam.booking.entity.Booking;
import com.coviam.booking.repository.BookingRepository;
import com.coviam.booking.service.BookingService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;


@Service

public class BookingServiceImpl implements BookingService {

    @Value("${endpoint.getFlightItinerary}")
    private String getFlightItinerary;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    RestTemplate restTemplate;

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
     * GET  All BOOKING DETAILS
     *
     * @param superPnr : SUPERPNR OF THE BOOKING
     * @return : BOOKINGDETAIL OBJECT
     */
    @Override
    public BookingDetailsDTO getBookingDetailsFromSuperPnr(String superPnr) {
        BookingDetailsDTO bookingDetailsDTO =new BookingDetailsDTO();
        Booking booking = bookingRepository.findBySuperPnr(superPnr);
        LOGGER.info("for superPnr : " + superPnr + " : " + booking);
        BookingDTO bookingDTO = new BookingDTO();
        BeanUtils.copyProperties(booking, bookingDTO);
        bookingDetailsDTO.setBookingDetails(bookingDTO);

        final String uriString = getFlightItinerary;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uriString).queryParam("superPnr", superPnr);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        JsonNode response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, JsonNode.class).getBody();
        JsonNode responseBody = response.path("response").path("flightDetailResponseDTOList");

        ObjectMapper objectMapper = new ObjectMapper();
        List<FlightDetailsResponseDTO> flightDetailsResponseDTOList = null;
        try {
            flightDetailsResponseDTOList = objectMapper.readValue(responseBody.toString(), new TypeReference<List<FlightDetailsResponseDTO>>() {
            });
            bookingDetailsDTO.setFlightDetailsResponseDTOS(flightDetailsResponseDTOList);
        }catch (Exception e){
            LOGGER.debug("Unable to map");
        }

        return bookingDetailsDTO;
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
