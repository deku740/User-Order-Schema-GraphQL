package com.graphql.services;

import com.graphql.entities.Order;
import com.graphql.helper.ExceptionHandler;
import com.graphql.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }

    public Order getOrder(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        return order;
    }

    public Order updateOrder(int orderId, Order updatedOrder) {
        Order order2 = orderRepo.findById(orderId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);

        order2.setOrderDetail(updatedOrder.getOrderDetail());
        order2.setAddress(updatedOrder.getAddress());
        order2.setPrice(updatedOrder.getPrice());
        order2.setUser(updatedOrder.getUser());

        return orderRepo.save(order2);
    }
    public boolean deleteOrder(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }

}
