package com.learnspringboot.springboot_transaction_management.service;

import com.learnspringboot.springboot_transaction_management.dto.OrderRequest;
import com.learnspringboot.springboot_transaction_management.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);

}
