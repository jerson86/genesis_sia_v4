package com.genesis.demo.helpers.mappers;

import com.genesis.demo.models.User;
import com.genesis.demo.models.dto.Response;
import com.genesis.demo.models.dto.UserResponse;

import java.time.LocalDate;
import java.util.List;

public class UserMapper {
    public static UserResponse userToUserResponse(List<User> user, String message){
        return UserResponse.builder()
                .response(Response.builder()
                        .date(LocalDate.now())
                        .message(List.of(message))
                        .build()
                )
                .users(user)
                .build();
    }
}
