package com.workintech.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user",schema = "ecommercebackend")
public class User{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Card> cards;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    private Store store;


    public void addCard(Card card){
        if(cards == null){
            cards = new ArrayList<>();
        }
        cards.add(card);
    }

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Order> orders = new ArrayList<>();






}
