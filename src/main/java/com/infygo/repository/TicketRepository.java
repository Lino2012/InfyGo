package com.infygo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infygo.entity.Ticket;

public interface TicketRepository
        extends JpaRepository<Ticket, Integer> {

}