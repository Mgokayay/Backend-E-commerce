package com.workintech.backend.controller;

import com.workintech.backend.dto.OrderResponse;
import com.workintech.backend.entity.Address;
import com.workintech.backend.entity.Card;
import com.workintech.backend.entity.Order;
import com.workintech.backend.entity.User;
import com.workintech.backend.service.AddressService;
import com.workintech.backend.service.CardService;
import com.workintech.backend.service.OrderService;
import com.workintech.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    private final UserService userService;

    private final AddressService addressService;

    private final CardService cardService;


    @Autowired
    public OrderController(OrderService orderService, UserService userService, AddressService addressService, CardService cardService) {
        this.orderService = orderService;
        this.userService = userService;
        this.addressService = addressService;
        this.cardService = cardService;
    }
    @GetMapping("/")
    public List<OrderResponse> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderResponse findById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @PostMapping("/{userId}/{addressId}/{cardId}")
    public OrderResponse save(@RequestBody Order order,@PathVariable Long userId,@PathVariable Long addressId,
                              @PathVariable Long cardId){
        User user = userService.findByUserId(userId);
        Address address = addressService.findByAddressId(addressId);
        Card card= cardService.findByCardId(cardId);
        order.setCard(card);
        order.setAddress(address);
        user.getOrders().add(order);
        order.setUser(user);
        return orderService.save(order);

    }
}
