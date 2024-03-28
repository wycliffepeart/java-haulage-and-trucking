package org.jht.server.controller;

import org.jht.server.dto.OrderRequestBody;
import org.jht.server.entity.OrderEntity;
import org.jht.server.repository.CustomerRepository;
import org.jht.server.repository.OrderRepository;
import org.jht.server.repository.RouteRepository;
import org.jht.server.repository.StaffRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/orders")
public class OrdersController {

    private final OrderRepository orderRepository;
    private final StaffRepository staffRepository;
    private final CustomerRepository customerRepository;
    private final RouteRepository routeRepository;

    public OrdersController(OrderRepository orderRepository, StaffRepository staffRepository, CustomerRepository customerRepository, RouteRepository routeRepository) {
        this.orderRepository = orderRepository;
        this.staffRepository = staffRepository;
        this.customerRepository = customerRepository;
        this.routeRepository = routeRepository;
    }

    @PostMapping
    public ResponseEntity<OrderEntity> post(@RequestBody OrderRequestBody body) throws ParseException {

        var route = this.routeRepository.findById(body.getRouteId()).get();
        var admin = this.staffRepository.findById(body.getAdminId()).get();
        var driver = this.staffRepository.findById(body.getDriverId()).get();
        var customer = this.customerRepository.findById(body.getCustomerId()).get();

        var order = new OrderEntity()
                .setAdmin(admin)
                .setDriver(driver)
                .setCustomer(customer)
                .setRoute(route)
                .setCreatedAt(LocalDate.now())
                .setSourceAddress(body.getSourceAddress())
                .setDestinationAddress(body.getDestinationAddress());

        return ResponseEntity.ok(this.orderRepository.save(order));
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> all() {
        return ResponseEntity.ok(this.orderRepository.findAll());
    }
}
