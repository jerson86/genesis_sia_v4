package com.genesis.demo.enums;

import lombok.Getter;

@Getter
public enum MessageResponse {
    USER_FOUND("User found"),
    USER_CREATED("User created"),
    USER_UPDATED("User updated"),
    USER_DELETED("User deleted");

    private final String message;
    MessageResponse(String message){
        this.message = message;
    }
}
