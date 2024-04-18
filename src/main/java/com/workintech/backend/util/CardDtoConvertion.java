package com.workintech.backend.util;

import com.workintech.backend.dto.CardResponse;
import com.workintech.backend.entity.Card;

import java.util.ArrayList;
import java.util.List;

public class CardDtoConvertion {


    public static List<CardResponse>  convertCardList(List<Card> cards){

        List<CardResponse> cardResponses = new ArrayList<>();
        cards.stream().forEach(card -> cardResponses.add(new CardResponse(card.getCardId(),card.getCardNo(),card.getCardExpireMonth()
        ,card.getCardExpireYear(),card.getCardCcv(),card.getCardName())));
        return cardResponses;
    }

    public static CardResponse convertCard(Card card){
        return new CardResponse(card.getCardId(),card.getCardNo(),card.getCardExpireMonth()
                ,card.getCardExpireYear(),card.getCardCcv(),card.getCardName());
    }
}
