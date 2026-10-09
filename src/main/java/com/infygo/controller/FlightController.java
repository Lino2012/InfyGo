package com.infygo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infygo.dto.FlightDTO;
import com.infygo.service.FlightService;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/infygo/flights/sources")
    public List<String> getSources() {
        return flightService.getSources();
    }

    @GetMapping("/infygo/flights/destinations")
    public List<String> getDestinations() {
        return flightService.getDestinations();
    }

    @GetMapping("/infygo/flights/{source}/{destination}/{journeyDate}")
    public List<FlightDTO> searchFlights(
            @PathVariable String source,
            @PathVariable String destination,
            @PathVariable LocalDate journeyDate) {

        return flightService.searchFlights(
                source,
                destination,
                journeyDate);
    }
}