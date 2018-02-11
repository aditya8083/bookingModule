package com.coviam.booking.repository;

import com.coviam.booking.entity.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking,String> {

    @Query(value = "SELECT B FROM Booking B WHERE B.superPnr = :superPnr")
    Booking findBySuperPnr(@Param("superPnr") String superPnr);
}
