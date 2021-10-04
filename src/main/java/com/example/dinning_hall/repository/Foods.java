package com.example.dinning_hall.repository;

import com.example.dinning_hall.domain.model.Food;
import com.example.dinning_hall.domain.model.enums.CookingApparatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Foods {
    private static List<Food> foods = new ArrayList<>();

    static {
        foods.add(new Food(1, "pizza", 20, 2, CookingApparatus.OVEN));
        foods.add(new Food(2, "salad", 7, 1, CookingApparatus.STOVE));
        foods.add(new Food(3, "Scallop Sashimi with Meyer Lemon Confit", 35, 3, null));
        foods.add(new Food(4, "Island Duck with Mulberry Mustard", 35, 3, CookingApparatus.OVEN));
        foods.add(new Food(5, "Waffles", 10, 1, CookingApparatus.STOVE));
        foods.add(new Food(6, "Aubergine", 20, 1, null));
        foods.add(new Food(7, "Lasagna", 30, 2, CookingApparatus.OVEN));
        foods.add(new Food(8, "Gyros", 15, 1, null));
    }

    public static Food getFoodById(int id) {
        return foods.stream().filter(food -> food.getId()==id).findFirst().get();
    }

    public static int  getTheHighestPreparationTimeFood(List<Integer> list){
        int max = 0;
        for (Food food: foods) {
            if (food.getPreparationTime()> max){
                max = food.getPreparationTime();
            }
        }
        return max;
    }

}
