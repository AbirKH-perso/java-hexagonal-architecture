package com.exalt.service.exceptions;

public class AccountExistsAlreadyException extends IllegalArgumentException{
    public AccountExistsAlreadyException(String message) {
        super(message);
    }
}
