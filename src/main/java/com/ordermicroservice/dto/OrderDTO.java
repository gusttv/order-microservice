package com.ordermicroservice.dto;

import com.ordermicroservice.domain.order.OrderStatus;

import java.time.LocalDateTime;


public record OrderDTO (
        String id,
        String userId,
        Double totalAmount,
        OrderStatus orderStatus,
        LocalDateTime createdAt
){
}
