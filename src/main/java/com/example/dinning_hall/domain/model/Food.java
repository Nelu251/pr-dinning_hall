package com.example.dinning_hall.domain.model;

import com.example.dinning_hall.domain.model.enums.CookingApparatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Food {
    private int id;
    private String name;
    private int preparationTime;
    private int complexity;
    private CookingApparatus cookingApparatus;
}
