package com.affordmed.logging_middleware.controller;

import com.affordmed.logging_middleware.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private LoggingService loggingService;

    @GetMapping("/test")
    public String test() {

        loggingService.log(
                "backend",
                "info",
                "controller",
                "Test API called"
        );

        return "Working";
    }
}