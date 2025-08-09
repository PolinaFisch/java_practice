package com.example.chatgpt.bigTask01.exception;

public class BookAlreadyLoanedException extends RuntimeException {
    public BookAlreadyLoanedException(String message) {
        super(message);
    }
}