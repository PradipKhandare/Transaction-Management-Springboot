package com.learnspringboot.springboot_transaction_management.repository;

import com.learnspringboot.springboot_transaction_management.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
