package com.infygo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infygo.entity.Card;

public interface CardRepository
        extends JpaRepository<Card, Integer> {
}