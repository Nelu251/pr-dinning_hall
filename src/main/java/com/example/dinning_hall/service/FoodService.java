package com.example.dinning_hall.service;

import com.example.dinning_hall.repository.Foods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private Foods foods;


}
