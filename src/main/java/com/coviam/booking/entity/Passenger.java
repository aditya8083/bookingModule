package com.coviam.booking.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = Passenger.TABLE_NAME)
public class Passenger implements Serializable {
    public static final String TABLE_NAME = "booking_user_details";

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "string_generator")
    @GenericGenerator(name="string_generator", strategy = "uuid2")
    private String id;

    @Column(name="user_name")
    private String name;

    @Column(name="user_age")
    private String age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    @JsonBackReference
    private Booking booking;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", booking=" + booking +
                '}';
    }
}
