package com.coviam.booking.dto;

import com.coviam.booking.entity.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.coviam.booking.entity.Booking.Status.PENDING;

public class BookingDetailsDTO {

     private BookingDTO bookingDetails;
     private List<FlightDetailsResponseDTO> flightDetailsResponseDTOS;


    public BookingDTO getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookingDTO bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public List<FlightDetailsResponseDTO> getFlightDetailsResponseDTOS() {
        return flightDetailsResponseDTOS;
    }

    public void setFlightDetailsResponseDTOS(List<FlightDetailsResponseDTO> flightDetailsResponseDTOS) {
        this.flightDetailsResponseDTOS = flightDetailsResponseDTOS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingDetailsDTO)) return false;
        BookingDetailsDTO that = (BookingDetailsDTO) o;
        return Objects.equals(bookingDetails, that.bookingDetails) &&
                Objects.equals(flightDetailsResponseDTOS, that.flightDetailsResponseDTOS);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookingDetails, flightDetailsResponseDTOS);
    }

    @Override
    public String toString() {
        return "BookingDetailsDTO{" +
                "bookingDetails=" + bookingDetails +
                ", flightDetailsResponseDTOS=" + flightDetailsResponseDTOS +
                '}';
    }


}
