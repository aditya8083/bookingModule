//package com.coviam.booking.config;
//
//
//import com.coviam.booking.BookingServiceApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.core.env.Environment;
//
//import java.util.Properties;
//
//public class WebAppInitializer extends SpringBootServletInitializer {
//
//
//  private static Properties getProperties() {
//    Properties props = new Properties();
//    props.put("spring.config.location", "file:" + System.getenv("BOOKING_CONF_DIR") + "booking/");
//    return props;
//  }
//
//  @Override
//  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//    return application.sources(BookingServiceApplication.class).properties(getProperties());
//  }
//}
