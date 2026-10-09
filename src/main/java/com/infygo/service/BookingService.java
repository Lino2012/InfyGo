package com.infygo.service;

import java.util.List;

import com.infygo.dto.TicketDTO;
import com.infygo.entity.Passenger;

public interface BookingService {

    TicketDTO bookTicket(
            Integer flightId,
            Integer userId,
            List<Passenger> passengers);

}