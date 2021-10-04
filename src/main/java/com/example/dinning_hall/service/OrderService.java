package com.example.dinning_hall.service;

import com.example.dinning_hall.domain.model.Order;
import com.example.dinning_hall.repository.Foods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class OrderService {
    @Autowired
    private Foods foods;

    public Order generateOrder(){

        Random random = new Random();
        Order order = new Order();
        order.setId(random.nextInt(999999999));
        order.setItmes(Arrays.asList(
                random.nextInt(8),
                random.nextInt(8),
                random.nextInt(8),
                random.nextInt(8)));
        order.setPriority(random.nextInt(3));
        order.setMaxWait((int)(foods.getTheHighestPreparationTimeFood(order.getItmes()) * 1.3));

        return order;
    }

}
