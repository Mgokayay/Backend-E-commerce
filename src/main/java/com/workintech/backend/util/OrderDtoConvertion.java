package com.workintech.backend.util;

import com.workintech.backend.dto.OrderResponse;
import com.workintech.backend.entity.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDtoConvertion {


    public static List<OrderResponse>  convertOrderList(List<Order> orders){
        List<OrderResponse> orderResponses=new ArrayList<>();
        orders.stream().forEach(order -> orderResponses.add(new OrderResponse(order.getId(), LocalDateTime.now()
        ,order.getUser().getId(),AddressDtoConvertion.convertAddress(order.getAddress()
        ), CardDtoConvertion.convertCard(order.getCard()))));
        return orderResponses;
    }

    public static OrderResponse convertOrder(Order order){
        return new OrderResponse(order.getId(),LocalDateTime.now()
                ,order.getUser().getId(),AddressDtoConvertion.convertAddress(order.getAddress()),CardDtoConvertion.convertCard(order.getCard()));
    }
}
