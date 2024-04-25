package com.workintech.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user",schema = "ecommercebackend")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long cardId ;

    @Column(name = "card_no")
    private Long cardNo;

    @Column(name = "card_expire_month")
    private Long cardExpireMonth;

    @Column(name = "card_expire_year")
    private Long cardExpireYear;

    @Column(name = "card_ccv")
    private Long cardCcv;

    @Column(name = "card_name")
    private String cardName;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "card")
    private Order order;
}
