package org.jht.server.controller;

import org.jht.server.entity.Route;
import org.jht.server.repository.RouteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/routes")
public class RouteController {

    private final RouteRepository routeRepository;

    public RouteController(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @PostMapping
    public ResponseEntity<Route> post(@RequestBody Route route){
        return ResponseEntity.ok(this.routeRepository.save(route));
    }

    @GetMapping
    public ResponseEntity<List<Route>> get(){
        return ResponseEntity.ok(this.routeRepository.findAll());
    }
}
