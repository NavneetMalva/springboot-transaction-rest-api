package com.springboot.transaction.controller;

import com.springboot.transaction.dto.OrderRequest;
import com.springboot.transaction.dto.OrderResponse;
import com.springboot.transaction.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.placeOrder(orderRequest)) ;
    }

    @GetMapping
    public String hello(){
        return "Hello Human !!";
    }
}
