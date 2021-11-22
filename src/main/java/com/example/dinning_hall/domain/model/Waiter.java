package com.example.dinning_hall.domain.model;

import com.example.dinning_hall.controllers.WaiterController;
import com.example.dinning_hall.domain.dto.OrderRequest;
import com.example.dinning_hall.domain.model.enums.TableStatus;
import com.example.dinning_hall.repository.Tables;

import com.example.dinning_hall.service.WaiterService;
import java.util.NoSuchElementException;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
//@Scope("prototype")
public class Waiter implements Runnable {

    private int id;
    private Order order;
    //
    //    @Autowired
    //    private WaiterController waiterController;
    @Autowired
    private WaiterService waiterService;

    public synchronized OrderRequest searchOrders() {
        //        if (Tables.findWaitingTable() != null) {
        //            Table table = Tables.findWaitingTable();
        //            assert table != null;
        //            this.order = table.generateOrder();
        //
        //            OrderRequest orderRequest = new OrderRequest(
        //                    order.getId(),
        //                    table.getId(),
        //                    this.id,
        //                    order.getItmes(),
        //                    order.getPriority(),
        //                    order.getMaxWait(),
        //                    System.currentTimeMillis() / 1000L);
        //
        //            table.setStatus(TableStatus.WAITING_TO_BE_SERVED);
        //            return orderRequest;
        //        }
        //        return null;
        try {
            var table = Tables.findWaitingTable();
            this.order = table.generateOrder();
            var orderRequest = new OrderRequest(
                order.getId(),
                table.getId(),
                this.id,
                order.getItmes(),
                order.getPriority(),
                order.getMaxWait(),
                System.currentTimeMillis() / 1000L
            );
        } catch (NoSuchElementException ex) {
            System.out.println("No more tables to serve");
        }
    }

    @Override
    public void run() {

        while (searchOrders() != null) {
            waiterService.sendOrderRequest(searchOrders());
        }
    }
}
