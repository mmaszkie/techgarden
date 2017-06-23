package com.techgarden.tasks.payu.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techgarden.tasks.payu.gateway.request.OrderCreateRequest;
import com.techgarden.tasks.payu.gateway.response.OrderCreateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PayUClient {

    private static final Logger logger = LoggerFactory.getLogger(PayUClient.class);

    private final String createOrderURL;
    private final RestTemplate restTemplate;

    @Autowired
    PayUClient(RestTemplate restTemplate, @Value("${payu.createOrder.url}") String createOrderURL) {
        this.restTemplate = restTemplate;
        this.createOrderURL = createOrderURL;
    }

    OrderCreateResponse createOrder(OrderCreateRequest request, String token) {
        logger.info("OrderCreateRequest body: " + convertObjectToFormattedJSON(request));
        OrderCreateResponse response = sendOrderCreateRequest(request, token);
        logger.info("OrderCreateResponse body: " + convertObjectToFormattedJSON(response));
        return response;
    }

    private OrderCreateResponse sendOrderCreateRequest(OrderCreateRequest order, String token) {
        ResponseEntity<OrderCreateResponse> response = sendHttpReuest(order, prepareHttpHeaders(token));
        return enrichResponseBodyWithHttpCode(response.getBody(), response.getStatusCodeValue());
    }

    private HttpHeaders prepareHttpHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);
        return headers;
    }

    private ResponseEntity<OrderCreateResponse> sendHttpReuest(OrderCreateRequest order, HttpHeaders headers) {
        HttpEntity<OrderCreateRequest> request = new HttpEntity<>(order, headers);
        return restTemplate.exchange(createOrderURL, HttpMethod.POST, request, OrderCreateResponse.class);
    }

    private OrderCreateResponse enrichResponseBodyWithHttpCode(OrderCreateResponse response, int httpCode) {
        response.setHttpCode(httpCode);
        return response;
    }

    private String convertObjectToFormattedJSON(Object object) {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}