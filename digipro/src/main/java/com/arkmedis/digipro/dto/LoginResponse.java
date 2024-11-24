package com.arkmedis.digipro.dto;

import com.arkmedis.digipro.entity.User;
import lombok.Data;

@Data
public class LoginResponse {
    private String message;
    private Long userId;
    private String name;
    private String email;
    private User.Role role;
}

