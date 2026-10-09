package com.infygo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infygo.dto.FlightDTO;
import com.infygo.entity.Flight;
import com.infygo.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<String> getSources() {
        return flightRepository.getSources();
    }

    @Override
    public List<String> getDestinations() {
        return flightRepository.getDestinations();
    }

    @Override
    public List<FlightDTO> searchFlights(
            String source,
            String destination,
            LocalDate journeyDate) {

        List<Flight> flights =
                flightRepository
                        .findBySourceIgnoreCaseAndDestinationIgnoreCaseAndJourneyDate(
                                source,
                                destination,
                                journeyDate);

        List<FlightDTO> flightDTOList = new ArrayList<>();

        for (Flight flight : flights) {

            FlightDTO dto = new FlightDTO();

            dto.setFlightId(flight.getFlightId());
            dto.setAirline(flight.getAirline());
            dto.setSource(flight.getSource());
            dto.setDestination(flight.getDestination());
            dto.setDepartureTime(flight.getDepartureTime());
            dto.setArrivalTime(flight.getArrivalTime());
            dto.setFare(flight.getFare());
            dto.setAvailableSeats(flight.getAvailableSeats());
            dto.setJourneyDate(flight.getJourneyDate());

            flightDTOList.add(dto);
        }

        return flightDTOList;
    }
}