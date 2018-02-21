package com.coviam.booking.kafka.storage;

import com.coviam.booking.dto.PaymentStatusDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageStorage {

    private List<PaymentStatusDTO> storage = new ArrayList<>();

    public void put(PaymentStatusDTO message){
        storage.add(message);
    }

    @Override
    public String toString(){
        StringBuffer info = new StringBuffer();
        storage.forEach(msg->info.append(msg).append("<br/>"));
        return info.toString();
    }

    public void clear(){
        storage.clear();
    }
}
