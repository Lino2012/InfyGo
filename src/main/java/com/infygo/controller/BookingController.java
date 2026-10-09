package com.infygo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infygo.dto.TicketDTO;
import com.infygo.entity.Passenger;
import com.infygo.service.BookingService;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/infygo/book/{flightId}/{userId}")
    public TicketDTO bookTicket(
            @PathVariable Integer flightId,
            @PathVariable Integer userId,
            @RequestBody List<Passenger> passengers) {

        return bookingService.bookTicket(
                flightId,
                userId,
                passengers);
    }
}