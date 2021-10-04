package com.example.dinning_hall.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderRequest {
    private int order_id;
    private int table_id;
    private int waiter_id;
    private List<Integer> items;
    private int priority;
    private int max_wait;
    private long pick_up_time;
}
