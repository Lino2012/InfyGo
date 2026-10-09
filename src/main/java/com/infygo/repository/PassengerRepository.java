package com.infygo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infygo.entity.Passenger;

public interface PassengerRepository
        extends JpaRepository<Passenger, Integer> {

}