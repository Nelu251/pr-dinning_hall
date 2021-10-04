package com.example.dinning_hall.service;

import com.example.dinning_hall.domain.dto.OrderRequest;

import com.example.dinning_hall.domain.model.Waiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WaiterService {

    @Autowired
    private Waiter waiter;

    private final RestTemplate restTemplate;

    public WaiterService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String sendOrderRequest(OrderRequest orderRequest) {
        HttpEntity<OrderRequest> entity = new HttpEntity<>(orderRequest);
        return restTemplate.exchange("http://localhost:8080/sendOrder", HttpMethod.POST, entity, String.class).getBody();
    }

    public void serving(){
        Thread thread = new Thread(waiter);
        thread.start();
    }
}
