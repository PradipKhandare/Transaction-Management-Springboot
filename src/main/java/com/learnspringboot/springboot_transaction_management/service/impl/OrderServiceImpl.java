package com.learnspringboot.springboot_transaction_management.service.impl;

import com.learnspringboot.springboot_transaction_management.dto.OrderRequest;
import com.learnspringboot.springboot_transaction_management.dto.OrderResponse;
import com.learnspringboot.springboot_transaction_management.entity.Order;
import com.learnspringboot.springboot_transaction_management.entity.Payment;
import com.learnspringboot.springboot_transaction_management.exception.PaymentException;
import com.learnspringboot.springboot_transaction_management.repository.OrderRepository;
import com.learnspringboot.springboot_transaction_management.repository.PaymentRepository;
import com.learnspringboot.springboot_transaction_management.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    PaymentRepository paymentRepository;


    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional()
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setOrderStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getCardType().equals("DEBIT")){
                throw new PaymentException("Payment card type do not support.");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());

        orderResponse.setStatus(order.getOrderStatus());

        orderResponse.setMessage("Successfully placed order.");

        return orderResponse;
    }
}
