package com.genesis.demo.enums;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    USER_NOT_FOUND("User not found"),
    USER_EMAIL_EXISTS("The email is already registered");

    private final String message;
    ErrorMessage(String message){
        this.message = message;
    }
}
