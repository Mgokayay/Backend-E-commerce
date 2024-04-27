package com.workintech.backend.service;

import com.workintech.backend.dto.OrderResponse;
import com.workintech.backend.entity.Order;

import java.util.List;

public interface OrderService {

    List<OrderResponse> findAll();

    OrderResponse save(Order order);

    OrderResponse findById(Long id);

    Order findByOrderId(Long id);


}
