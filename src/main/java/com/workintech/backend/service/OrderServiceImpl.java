package com.workintech.backend.service;

import com.workintech.backend.dto.OrderResponse;
import com.workintech.backend.entity.Order;
import com.workintech.backend.exceptions.CommonException;
import com.workintech.backend.repository.OrderRepository;
import com.workintech.backend.util.OrderDtoConvertion;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderResponse> findAll() {
        List<Order> orders = orderRepository.findAll();
        return OrderDtoConvertion.convertOrderList(orders);
    }

    @Override
    public OrderResponse save(Order order) {
        orderRepository.save(order);
        return OrderDtoConvertion.convertOrder(order);
    }

    @Override
    public OrderResponse findById(Long id) {
        Optional<Order> orderOptional=orderRepository.findById(id);
        if(orderOptional.isPresent()){
            return OrderDtoConvertion.convertOrder(orderOptional.get());
        }
        throw new CommonException("Order is not exist with given id " + id, HttpStatus.NOT_FOUND);

    }

    @Override
    public Order findByOrderId(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            return orderOptional.get();
        }
        throw new CommonException("Order is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

}
