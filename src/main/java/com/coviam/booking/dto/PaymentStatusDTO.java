package com.coviam.booking.dto;

import com.coviam.booking.entity.Booking;

import java.io.Serializable;

public class PaymentStatusDTO implements Serializable {

    String superPnr;
    String paymentid;
    Booking.Status status;

    public String getSuperPnr() {
        return superPnr;
    }

    public void setSuperPnr(String superPnr) {
        this.superPnr = superPnr;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public Booking.Status getStatus() {
        return status;
    }

    public void setStatus(Booking.Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentStatusDTO that = (PaymentStatusDTO) o;

        if (!superPnr.equals(that.superPnr)) return false;
        if (!paymentid.equals(that.paymentid)) return false;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = superPnr.hashCode();
        result = 31 * result + paymentid.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PaymentStatusDTO{" +
                "superPnr='" + superPnr + '\'' +
                ", paymentid='" + paymentid + '\'' +
                ", status=" + status +
                '}';
    }
}
