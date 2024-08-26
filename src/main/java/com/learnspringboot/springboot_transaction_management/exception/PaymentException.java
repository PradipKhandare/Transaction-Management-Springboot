package com.learnspringboot.springboot_transaction_management.exception;

public class PaymentException extends RuntimeException {

    public PaymentException(String message) {
        super(message);
    }
}
