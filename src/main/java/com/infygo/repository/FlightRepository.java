package com.infygo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infygo.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query("select distinct f.source from Flight f")
    List<String> getSources();

    @Query("select distinct f.destination from Flight f")
    List<String> getDestinations();

    List<Flight> findBySourceIgnoreCaseAndDestinationIgnoreCaseAndJourneyDate(
            String source,
            String destination,
            LocalDate journeyDate);
}