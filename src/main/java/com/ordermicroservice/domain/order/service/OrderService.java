package com.ordermicroservice.domain.order.service;

import com.ordermicroservice.domain.order.model.Order;

public interface OrderService {
    Order createOrder(Order order);
}
