package com.coviam.booking.entity;

import com.coviam.booking.util.Auditable;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.coviam.booking.entity.Booking.Status.PENDING;

@Entity
@Table(name = Booking.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class Booking extends Auditable<String> implements Serializable {
    public static final String TABLE_NAME = "booking_master";

    @Id
    @GeneratedValue(generator = "string_generator")
    @GenericGenerator(name="string_generator", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "super_pnr")
    private String superPnr;

    @Column(name = "booking_status")
    @Enumerated(EnumType.STRING)
    private Status bookingStatus = PENDING;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private Status paymentStatus = PENDING;

    @Column(name = "booking_type")
    private String bookingType = "flight";

    @Column(name = "booking_source")
    private String bookingSource = "web";

    @Column(name = "booking_phone_number")
    private String phoneNumber;

    @Column(name = "booking_email")
    private String bookingEmail;

    @OneToMany(
            mappedBy = "booking",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JsonManagedReference
    private List<Passenger> passengers = new ArrayList<>();

    public static enum Status {PENDING, SUCCESSFUL, DEFERRED, CANCELLED};

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Status bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getSuperPnr() {
        return superPnr;
    }

    public void setSuperPnr(String superPnr) {
        this.superPnr = superPnr;
    }

    public Status getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Status paymentStatus) {
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

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", superPnr='" + superPnr + '\'' +
                ", bookingStatus=" + bookingStatus +
                ", paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", paymentStatus=" + paymentStatus +
                ", bookingType='" + bookingType + '\'' +
                ", bookingSource='" + bookingSource + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bookingEmail='" + bookingEmail + '\'' +
                ", passengersCount=" + passengers.size() +
                '}';
    }
}
