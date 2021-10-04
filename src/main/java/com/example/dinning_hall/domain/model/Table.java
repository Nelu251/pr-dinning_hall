package com.example.dinning_hall.domain.model;

import com.example.dinning_hall.domain.model.enums.TableStatus;
import com.example.dinning_hall.repository.Foods;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Random;

@Data
@AllArgsConstructor
public class Table {
    private int id;
    private TableStatus status;

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
        order.setMaxWait((int)(Foods.getTheHighestPreparationTimeFood(order.getItmes()) * 1.3));
        order.setOrder_pick_up_timestamp(System.currentTimeMillis() / 1000L);

        return order;
    }

}
