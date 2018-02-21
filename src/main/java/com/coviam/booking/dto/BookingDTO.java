package com.coviam.booking.dto;

import com.coviam.booking.entity.enums.BookingStatus;
import com.coviam.booking.entity.enums.PaymentStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookingDTO implements Serializable{

    private String id;
    private String userId;
    private String superPnr;
    private String bookingStatus = BookingStatus.PENDING.toString();
    private String paymentId;
    private Double amount;
    private String paymentStatus = PaymentStatus.PENDING.toString();
    private String bookingType = "flight";
    private String bookingSource = "web";
    private String phoneNumber;
    private String bookingEmail;
    private List<PassengerDTO> passengers = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSuperPnr() {
        return superPnr;
    }

    public void setSuperPnr(String superPnr) {
        this.superPnr = superPnr;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(String bookingSource) {
        this.bookingSource = bookingSource;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBookingEmail() {
        return bookingEmail;
    }

    public void setBookingEmail(String bookingEmail) {
        this.bookingEmail = bookingEmail;
    }

    public List<PassengerDTO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDTO> passengers) {
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingDTO that = (BookingDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (superPnr != null ? !superPnr.equals(that.superPnr) : that.superPnr != null) return false;
        if (bookingStatus != null ? !bookingStatus.equals(that.bookingStatus) : that.bookingStatus != null)
            return false;
        if (paymentId != null ? !paymentId.equals(that.paymentId) : that.paymentId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (paymentStatus != null ? !paymentStatus.equals(that.paymentStatus) : that.paymentStatus != null)
            return false;
        if (bookingType != null ? !bookingType.equals(that.bookingType) : that.bookingType != null) return false;
        if (bookingSource != null ? !bookingSource.equals(that.bookingSource) : that.bookingSource != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (bookingEmail != null ? !bookingEmail.equals(that.bookingEmail) : that.bookingEmail != null) return false;
        return passengers != null ? passengers.equals(that.passengers) : that.passengers == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (superPnr != null ? superPnr.hashCode() : 0);
        result = 31 * result + (bookingStatus != null ? bookingStatus.hashCode() : 0);
        result = 31 * result + (paymentId != null ? paymentId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (paymentStatus != null ? paymentStatus.hashCode() : 0);
        result = 31 * result + (bookingType != null ? bookingType.hashCode() : 0);
        result = 31 * result + (bookingSource != null ? bookingSource.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (bookingEmail != null ? bookingEmail.hashCode() : 0);
        result = 31 * result + (passengers != null ? passengers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", superPnr='" + superPnr + '\'' +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", bookingType='" + bookingType + '\'' +
                ", bookingSource='" + bookingSource + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bookingEmail='" + bookingEmail + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}



