package com.genesis.demo.models.dto;

import com.genesis.demo.models.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class UserResponse {
    private Response response;
    private List<User> users;
}
