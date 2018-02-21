package controller;


import com.coviam.booking.controllers.BookingController;
import com.coviam.booking.dto.BookingDetailsDTO;
import com.coviam.booking.service.BookingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BookingControllerTest {

    @InjectMocks
    BookingController bookingController;

    @Mock
    BookingService bookingService;

    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();
    }

    @Test
    public void getBooking_success() throws Exception {

        BookingDetailsDTO value = new BookingDetailsDTO();

        Mockito.when(bookingService.getBookingDetailsFromSuperPnr("abc")).thenReturn(value);

        mockMvc.perform(get("/booking/superPnr/abc"))
                .andExpect(status().isOk());

        Mockito.verify(bookingService, Mockito.times(1)).getBookingDetailsFromSuperPnr("abc");
    }

    @After
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(bookingService);
    }
}
