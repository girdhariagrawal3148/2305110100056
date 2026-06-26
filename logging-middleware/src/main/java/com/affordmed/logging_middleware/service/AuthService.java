package com.affordmed.logging_middleware.service;

import com.affordmed.logging_middleware.dto.AuthResponse;
import com.affordmed.logging_middleware.utils.TokenManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public void saveToken(AuthResponse response) {

        TokenManager.setToken(response.getAccessToken());

    }

}