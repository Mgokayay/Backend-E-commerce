package com.workintech.backend.service;

import com.workintech.backend.dto.CardResponse;
import com.workintech.backend.entity.Card;

import java.util.List;

public interface CardService {

    List<CardResponse> findAll();

    CardResponse findById(Long id);

    CardResponse save(Card card);

    CardResponse delete(Long id);

    Card findByCardId(Long id);
}
