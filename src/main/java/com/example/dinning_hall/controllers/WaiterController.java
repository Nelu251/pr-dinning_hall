package com.example.dinning_hall.controllers;

import com.example.dinning_hall.domain.dto.OrderRequest;
import com.example.dinning_hall.domain.model.Waiter;
import com.example.dinning_hall.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WaiterController {
    @Autowired
    private WaiterService waiterService;
    @Autowired
    private Waiter waiter;

    @PostMapping("/order")
    public String sendRequestOrder(@RequestBody OrderRequest orderRequest){
        return waiterService.sendOrderRequest(orderRequest);
    }
}
