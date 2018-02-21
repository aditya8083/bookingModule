package com.coviam.booking.kafka.consumer;

import com.coviam.booking.dto.PaymentStatusDTO;
import com.coviam.booking.entity.Booking;
import com.coviam.booking.kafka.storage.MessageStorage;
import com.coviam.booking.service.BookingService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumer {

    @Autowired
    Logger log;

    @Autowired
    MessageStorage storage;

    @Autowired
    public BookingService bookingService;

    @KafkaListener(
            id = "customer1",
            groupId = "cg1",
            topics = "${update.booking.topic}"
    )
    public void processMessage(ConsumerRecord<String, PaymentStatusDTO> record) {
        log.debug("Message received with offset = {}, key = {} and value = {} for topic = {} in partition = {}", record.offset(),
                record.key(), record.value(), record.topic(), record.partition());
        storage.put(record.value());

        Booking booking = bookingService.getBookingFromSuperPnr(record.value().getSuperPnr().toString());
        log.debug("booking = {}", booking);
        try {
            Booking updatedBooking = bookingService.updateBookingPaymentStatus(record.value(), booking);
        }catch (IllegalArgumentException ex) {
            log.error("No Booking was found for the given superPnr");
        }
    }

}
