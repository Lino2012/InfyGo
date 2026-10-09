package com.infygo.service;

import java.time.LocalDate;
import java.util.List;

import com.infygo.dto.FlightDTO;

public interface FlightService {

    List<String> getSources();

    List<String> getDestinations();

    List<FlightDTO> searchFlights(
            String source,
            String destination,
            LocalDate journeyDate);
}