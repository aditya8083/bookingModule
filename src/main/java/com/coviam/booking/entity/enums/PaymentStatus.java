package com.coviam.booking.entity.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by avinashkumar on 19/02/2018 AD.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public enum PaymentStatus implements Serializable {

    PENDING("pending"),
    SUCCESSFUL("successful"),
    DEFERRED("deferred"),
    CANCELLED("cancelled");

    private final String paymentStatus;

    PaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String toString() {
        return this.paymentStatus;
    }

    public static PaymentStatus fromValue(final String paymentStatus) {

        for (PaymentStatus type : PaymentStatus.values()) {
            if (type.paymentStatus.equals(paymentStatus)){
                return type;
            }
        }
        return null;
    }
}
