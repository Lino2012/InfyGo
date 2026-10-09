package com.infygo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infygo.dto.PassengerDTO;
import com.infygo.dto.TicketDTO;
import com.infygo.entity.Flight;
import com.infygo.entity.Passenger;
import com.infygo.entity.Ticket;
import com.infygo.entity.User;
import com.infygo.repository.FlightRepository;
import com.infygo.repository.TicketRepository;
import com.infygo.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public TicketDTO bookTicket(
            Integer flightId,
            Integer userId,
            List<Passenger> passengers) {

        Flight flight =
                flightRepository.findById(flightId).orElseThrow();

        User user =
                userRepository.findById(userId).orElseThrow();

        int passengerCount = passengers.size();

        if (flight.getAvailableSeats() < passengerCount) {
            throw new RuntimeException(
                    "Seats not available");
        }

        double totalFare =
                passengerCount * flight.getFare();

        flight.setAvailableSeats(
                flight.getAvailableSeats()
                        - passengerCount);

        flightRepository.save(flight);

        Ticket ticket = new Ticket();

        ticket.setBookingDate(LocalDate.now());

        ticket.setPnr(generatePNR());

        ticket.setFlight(flight);

        ticket.setUser(user);

        ticket.setNoOfPassengers(passengerCount);

        ticket.setTotalFare(totalFare);

        Ticket savedTicket =
                ticketRepository.save(ticket);

        for (Passenger passenger : passengers) {

            passenger.setTicket(savedTicket);
        }

        savedTicket.setPassengers(passengers);

        ticketRepository.save(savedTicket);

        TicketDTO dto = new TicketDTO();

        dto.setPnr(savedTicket.getPnr());

        dto.setTotalFare(savedTicket.getTotalFare());

        dto.setNoOfPassengers(
                savedTicket.getNoOfPassengers());

        return dto;
    }

    private String generatePNR() {

        Random random = new Random();

        return "INFY"
                + (100000 + random.nextInt(900000));
    }
}