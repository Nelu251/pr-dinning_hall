package com.example.dinning_hall.domain;

import com.example.dinning_hall.domain.model.Waiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Waiter getWaiter(){
        return new Waiter();
    }
}
