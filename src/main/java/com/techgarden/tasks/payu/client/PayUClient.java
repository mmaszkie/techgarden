package com.techgarden.tasks.payu.client;

import com.techgarden.tasks.payu.client.request.OrderCreateRequest;
import com.techgarden.tasks.payu.client.response.OrderCreateResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PayUClient {

    private final String createOrderURL;
    private final RestTemplate restTemplate;

    public PayUClient(RestTemplate restTemplate, String createOrderURL) {
        this.restTemplate = restTemplate;
        this.createOrderURL = createOrderURL;
    }

    OrderCreateResponse createOrder(OrderCreateRequest order, String token) {
        ResponseEntity<OrderCreateResponse> response = sendHttpReuest(order, prepareHttpHeaders(token));
        return enrichResponseWithHttpCode(response.getBody(), response.getStatusCodeValue());
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

    private OrderCreateResponse enrichResponseWithHttpCode(OrderCreateResponse response, int httpCode) {
        response.setHttpCode(httpCode);
        return response;
    }
}