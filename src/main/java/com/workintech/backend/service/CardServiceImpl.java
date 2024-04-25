package com.workintech.backend.service;

import com.workintech.backend.dto.CardResponse;
import com.workintech.backend.entity.Card;
import com.workintech.backend.exceptions.CommonException;
import com.workintech.backend.repository.CardRepository;
import com.workintech.backend.util.CardDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService{


    private final CardRepository cardRepository;
    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<CardResponse> findAll() {
        List<Card> cards =cardRepository.findAll();
        return CardDtoConvertion.convertCardList(cards);
    }

    @Override
    public CardResponse findById(Long id) {
        Optional<Card> cardOptional=cardRepository.findById(id);
        if(cardOptional.isPresent()){
            return CardDtoConvertion.convertCard(cardOptional.get());
        }
        throw new CommonException("Card is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public CardResponse save(Card card) {
        cardRepository.save(card);
        return CardDtoConvertion.convertCard(card) ;
    }

    @Override
    public CardResponse delete(Long id) {
        Optional<Card> cardOptional=cardRepository.findById(id);
        if(cardOptional.isPresent()){
            cardRepository.delete(cardOptional.get());
            return CardDtoConvertion.convertCard(cardOptional.get());
        }
        throw new CommonException("Card is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Card findByCardId(Long id) {
        Optional<Card> cardOptional = cardRepository.findById(id);
        if (cardOptional.isPresent()) {
            cardRepository.delete(cardOptional.get());
            return cardOptional.get();
        }
        throw new CommonException("Card is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }
}
