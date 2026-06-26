package com.affordmed.logging_middleware.service;

import com.affordmed.logging_middleware.dto.LogRequest;
import com.affordmed.logging_middleware.dto.LogResponse;
import com.affordmed.logging_middleware.utils.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoggingService {

    private static final String LOG_URL =
            "http://4.224.186.213/evaluation-service/logs";

    @Autowired
    private RestTemplate restTemplate;

    public void log(String stack,
                    String level,
                    String packageName,
                    String message) {

        try {

            LogRequest request = new LogRequest(
                    stack,
                    level,
                    packageName,
                    message
            );

            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_JSON);

            headers.setBearerAuth(TokenManager.getToken());

            HttpEntity<LogRequest> entity =
                    new HttpEntity<>(request, headers);

            ResponseEntity<LogResponse> response =
                    restTemplate.exchange(
                            LOG_URL,
                            HttpMethod.POST,
                            entity,
                            LogResponse.class
                    );

            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println(
                        "Log Created : "
                                + response.getBody().getLogID()
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Logging Failed : "
                            + e.getMessage()
            );

        }

    }

}