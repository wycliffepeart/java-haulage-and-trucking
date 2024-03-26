package org.jht.server.controller;

import org.jht.server.entity.Route;
import org.jht.server.repository.RouteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/routes")
public class RouteController {

    private final RouteRepository routeRepository;

    public RouteController(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }


    @GetMapping
    public ResponseEntity<List<Route>> getAll(){
        return ResponseEntity.ok(this.routeRepository.findAll());
    }
}
