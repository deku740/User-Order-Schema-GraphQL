package com.graphql.controllers;

import com.graphql.entities.Order;
import com.graphql.entities.User;
import com.graphql.services.OrderService;
import com.graphql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class OrderController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;


    @MutationMapping
    public Order createOrder(@Argument String orderDetail, @Argument String address, @Argument int price, @Argument int userId){
        User user = userService.getUser(userId);

        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);

        return orderService.createOrder(order);
    }
    @QueryMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }
    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return orderService.getOrder(orderId);
    }

    @MutationMapping
    public Order updateOrder(@Argument int orderId, @Argument String orderDetail,
                             @Argument String address, @Argument int price,
                             @Argument int userId) {
        User user = userService.getUser(userId);

        Order updatedOrder = new Order();
        updatedOrder.setOrderDetail(orderDetail);
        updatedOrder.setAddress(address);
        updatedOrder.setPrice(price);
        updatedOrder.setUser(user);

        return orderService.updateOrder(orderId, updatedOrder);
    }
    @MutationMapping
    public boolean deleteOrder(@Argument int orderId){
        orderService.deleteOrder(orderId);
        return true;
    }
}
