package org.jht.server.controller;

import org.jht.server.entity.Salary;
import org.jht.server.repository.SalaryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/salaries")
public class SalaryController {

    private final SalaryRepository salaryRepository;

    public SalaryController(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @GetMapping
    public ResponseEntity<List<Salary>> all() {
        return ResponseEntity.ok(this.salaryRepository.findAll());
    }
}
