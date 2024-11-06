package com.ordermicroservice.domain.order.service;


import com.ordermicroservice.domain.order.OrderStatus;
import com.ordermicroservice.domain.order.model.Order;
import com.ordermicroservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(String orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> updateOrderStatus(String orderId, OrderStatus newStatus) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();

//            if (canChangeStatus(order.getOrderStatus(), newStatus)) {
//                order.setOrderStatus(newStatus);
//                orderRepository.save(order);
//            }
            order.setOrderStatus(newStatus);
            return Optional.of(order);

        }
        return Optional.empty();
    }


//    private boolean canChangeStatus(OrderStatus currentStatus, OrderStatus newStatus) {
//        if (currentStatus == OrderStatus.PENDING && (newStatus == OrderStatus.CONFIRMED
//                || newStatus == OrderStatus.CANCELED)) {
//            return true;
//        }
//        return false;
//    }
    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }
}