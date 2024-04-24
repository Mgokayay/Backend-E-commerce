package com.workintech.backend.controller;

import com.workintech.backend.dto.CardResponse;
import com.workintech.backend.entity.Card;
import com.workintech.backend.entity.User;
import com.workintech.backend.repository.CardRepository;
import com.workintech.backend.service.CardService;
import com.workintech.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;
    private final UserService userService;
    @Autowired
    public CardController(CardService cardService, UserService userService) {
        this.cardService = cardService;
        this.userService = userService;
    }


    @GetMapping
    public List<CardResponse> findAll(){

        return cardService.findAll();
    }

    @PostMapping("/{userId}")
    public CardResponse save(@RequestBody Card card,@PathVariable Long userId){
        User user = userService.findByUserId(userId);
        user.getCards().add(card);
        card.setUser(user);

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
