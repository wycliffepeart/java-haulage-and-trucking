package org.jht.server.controller;

import org.jht.server.entity.Staff;
import org.jht.server.repository.StaffRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/staffs")
public class StaffController {

    private final StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @GetMapping
    public ResponseEntity<List<Staff>> all(){
        return ResponseEntity.ok(this.staffRepository.findAll());
    }
}
