package com.workintech.backend.controller;

import com.workintech.backend.dto.CardResponse;
import com.workintech.backend.entity.Card;
import com.workintech.backend.repository.CardRepository;
import com.workintech.backend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;
    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @PostMapping
    public List<CardResponse> findAll(){
        return cardService.findAll();
    }

    @GetMapping("/")
    public CardResponse save(@RequestBody Card card){
        return cardService.save(card);
    }

    @GetMapping("/{id}")
    public CardResponse findById(@PathVariable Long id){
        return cardService.findById(id);
    }

    @DeleteMapping("{id}")
    public CardResponse delete(@PathVariable Long id){
        return cardService.delete(id);
    }
}
