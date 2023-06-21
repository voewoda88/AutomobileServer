package com.springprojects.automobileserver.services;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class ResponseService {
    public ResponseEntity<String> responseGeneration(String response, HttpStatus status) {
        String fullResponse = "{\"message\": \"" + response + "\"}";
        return ResponseEntity.status(status.value())
                .header("Content-Type", "application/json")
                .body(fullResponse);
    }
}
