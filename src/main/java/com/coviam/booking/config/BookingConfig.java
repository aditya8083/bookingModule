package com.coviam.booking.config;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@FeignClient("zuul-service")
public interface BookingConfig {
    @RequestMapping("/flight/flight/detail")
    String flightinfos();
}
