package com.coviam.booking;

import com.coviam.booking.config.BookingConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BookingServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(BookingServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate template =  new RestTemplate();
        template.getMessageConverters().add(new FormHttpMessageConverter());
        template.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                // Don't want restTemplate to handle my error.
            }
        });
        return template;
    }

    @Bean
    public Logger getLogger() {
        return LogManager.getLogger(this.getClass().getPackage().getName());
    }

}
