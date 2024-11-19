package com.thegaab.createURLShortner;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main implements RequestHandler<Map<String, Object>, Map<String, String>>{

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, String> handleRequest(Map<String, Object> input, Context context) {
        String body = input.get("body").toString();

        Map<String, String> bodyMap;
        try {
            bodyMap = objectMapper.readValue(body, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing request body", e);
        }

        String originalURL = bodyMap.get("originalURL");
        String expiryDate = bodyMap.get("expiryDate");

        String shortURLCode = UUID.randomUUID().toString().substring(0, 8);

        Map<String, String> response = new HashMap<>();
        response.put("code", shortURLCode);

        return response;
    }
}