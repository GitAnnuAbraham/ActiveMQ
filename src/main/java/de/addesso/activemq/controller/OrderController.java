package de.addesso.activemq.controller;

import de.addesso.activemq.service.OrderService;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }

    @GetMapping("/create")
    public String createOrder(@RequestParam String order) {
        orderService.sendOrder(order);
        return "Order sent to queue";
    }
}
