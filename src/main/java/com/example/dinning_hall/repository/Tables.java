package com.example.dinning_hall.repository;

import com.example.dinning_hall.domain.model.Table;
import com.example.dinning_hall.domain.model.enums.TableStatus;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Tables {
    private static final List<Table> tablesList = new ArrayList<>();

    static {
        tablesList.add(new Table(1, TableStatus.WAITING_TO_MAKE_ORDER));
        tablesList.add(new Table(2, TableStatus.WAITING_TO_MAKE_ORDER));
        tablesList.add(new Table(3, TableStatus.WAITING_TO_MAKE_ORDER));
        tablesList.add(new Table(4, TableStatus.WAITING_TO_MAKE_ORDER));
        tablesList.add(new Table(5, TableStatus.WAITING_TO_MAKE_ORDER));
    }

    public static Table findWaitingTable() {
        for (Table table: tablesList) {
            if (table.getStatus().equals(TableStatus.WAITING_TO_MAKE_ORDER)){
                return table;
            }
        }
        return null;
    }


}
