package org.jht.server.controller;

import org.jht.server.entity.OrderEntity;
import org.jht.server.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/orders")
public class OrdersController {

    private final OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<OrderEntity> post(@RequestBody OrderEntity order){
        return ResponseEntity.ok(this.orderRepository.save(order));
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> all(){
        return ResponseEntity.ok(this.orderRepository.findAll());
    }
}
