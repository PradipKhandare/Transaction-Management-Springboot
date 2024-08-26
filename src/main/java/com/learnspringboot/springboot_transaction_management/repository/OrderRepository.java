package com.learnspringboot.springboot_transaction_management.repository;

import com.learnspringboot.springboot_transaction_management.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
