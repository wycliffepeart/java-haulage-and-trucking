package org.jht.server.controller;

import org.jht.server.entity.Staff;
import org.jht.server.repository.StaffRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/staffs")
public class StaffController {

    private final StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @PostMapping
    public ResponseEntity<Staff> post(@RequestBody Staff staff){
        return ResponseEntity.ok(this.staffRepository.save(staff));
    }

    @GetMapping
    public ResponseEntity<List<Staff>> get(){
        return ResponseEntity.ok(this.staffRepository.findAll());
    }
}
