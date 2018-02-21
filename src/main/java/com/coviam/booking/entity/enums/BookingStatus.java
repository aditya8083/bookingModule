package com.coviam.booking.entity.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by avinashkumar on 19/02/2018 AD.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public enum BookingStatus implements Serializable {

    PENDING("pending"),
    SUCCESSFUL("successful"),
    DEFERRED("deferred"),
    CANCELLED("cancelled");

    private final String bookingStatus;

    BookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String toString() {
        return this.bookingStatus;
    }

    public static BookingStatus fromValue(final String bookingStatus) {

        for (BookingStatus type : BookingStatus.values()) {
            if (type.bookingStatus.equals(bookingStatus)){
                return type;
            }
        }
        return null;
    }
}
