package com.example.dinning_hall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class MainService {

    private final WaiterService waiterService;

    @PostConstruct
    void letsGo() {
        waiterService.serving();
    }

}