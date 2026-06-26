package com.affordmed.logging_middleware.utils;

public class TokenManager {

    private static String token;

    public static void setToken(String accessToken) {
        token = accessToken;
    }

    public static String getToken() {
        return token;
    }
}