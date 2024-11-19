package com.thegaab.createURLShortner;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main implements RequestHandler<Map<String, Object>, Map<String, String>>{

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final S3Client s3Client = S3Client.builder().build();

    @Override
    public Map<String, String> handleRequest(Map<String, Object> input, Context context) {
        String body = input.get("body").toString();

        Map<String, String> bodyMap;
        try {
            bodyMap = objectMapper.readValue(body, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing request body", e);
        }

        String originalUrl = bodyMap.get("originalUrl");
        String expiryDate = bodyMap.get("expiryDate");
        long expiryDateInSeconds = Long.parseLong(expiryDate);

        String shortURLCode = UUID.randomUUID().toString().substring(0, 8);

        UrlData urlData = new UrlData(originalUrl, expiryDateInSeconds);

        try{
            String urlDataJson = objectMapper.writeValueAsString(urlData);

            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket("url-shortener-storage-thegaab")
                    .key(shortURLCode + ".json")
                    .build();
            s3Client.putObject(request, RequestBody.fromString(urlDataJson));
        } catch (Exception e) {
            throw new RuntimeException("Error saving URL data to S3", e);
        }

        Map<String, String> response = new HashMap<>();
        response.put("code", shortURLCode);

        return response;
    }
}