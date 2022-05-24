package com.example.ebankingbackend.exceptions;

public class BankAccountNorFoundException extends Exception {
    public BankAccountNorFoundException(String message) {
        super(message);
    }
}
