package org.Testing.module;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.Testing.payload.Booking;
import org.Testing.payload.Bookingdates;

public class PayLoadManager {

    // java to json
    // create a payload
    ObjectMapper objectMapper;
    public String createPayload() throws JsonProcessingException {

        objectMapper = new ObjectMapper();
        Booking booking = new Booking();
        booking.setFirstname("Ishu");
        booking.setLastname("Anand");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast");
        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2023-01-01");
        bookingdates.setCheckout("2024-01-01");
        booking.setBookingdates(bookingdates);

        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;


    }

    public String updatepayload() throws JsonProcessingException {

        objectMapper = new ObjectMapper();
        Booking booking = new Booking();
        booking.setFirstname("Is");
        booking.setLastname("Anand");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast");
        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2023-01-01");
        bookingdates.setCheckout("2024-01-01");
        booking.setBookingdates(bookingdates);

        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;

    }


}
