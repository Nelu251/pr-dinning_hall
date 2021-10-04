package com.example.dinning_hall.domain.model;

import com.example.dinning_hall.controllers.WaiterController;
import com.example.dinning_hall.domain.dto.OrderRequest;
import com.example.dinning_hall.domain.model.enums.TableStatus;
import com.example.dinning_hall.repository.Tables;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class Waiter implements Runnable {
    private int id;
    private Order order;

    @Autowired
    private WaiterController waiterController;

    public synchronized OrderRequest searchOrders() throws NullPointerException {
        if (Tables.findWaitingTable() != null) {
            Table table = Tables.findWaitingTable();
            assert table != null;
            this.order = table.generateOrder();

            OrderRequest orderRequest = new OrderRequest(
                    order.getId(),
                    table.getId(),
                    this.id,
                    order.getItmes(),
                    order.getPriority(),
                    order.getMaxWait(),
                    System.currentTimeMillis() / 1000L);

            table.setStatus(TableStatus.WAITING_TO_BE_SERVED);
            return orderRequest;
        }
        return null;
    }

    @Override
    public void run() {
        try {
            searchOrders();
        } catch (NullPointerException e) {
            System.out.println("end of list");
        }

        if (searchOrders() != null) {
            waiterController.sendRequestOrder(searchOrders());
        }
    }
}
