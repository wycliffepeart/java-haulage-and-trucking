package org.jht.server.controller;

import org.jht.server.entity.Staff;
import org.jht.server.repository.StaffRepository;
import org.jht.server.support.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/staffs")
public class StaffController {

    private final StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @PostMapping
    public ResponseEntity<Staff> post(@RequestBody Staff staff) throws ParseException {
        staff.setCreatedAt(LocalDate.now());
        return ResponseEntity.ok(this.staffRepository.save(staff));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        this.staffRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping
    public ResponseEntity<List<Staff>> get(@RequestParam(required = false) Role role) {

        if (role != null) return ResponseEntity.ok(this.staffRepository.findAllByRole(role));

        return ResponseEntity.ok(this.staffRepository.findAll());
    }
}
