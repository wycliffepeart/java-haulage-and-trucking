package org.jht.server.controller;

import org.jht.server.dto.GenerateSalaryDTO;
import org.jht.server.entity.Salary;
import org.jht.server.repository.OrderRepository;
import org.jht.server.repository.SalaryRepository;
import org.jht.server.repository.StaffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/salaries")
public class SalaryController {

    private final SalaryRepository salaryRepository;

    private final StaffRepository staffRepository;

    private final OrderRepository orderRepository;

    private final Logger logger = LoggerFactory.getLogger(SalaryController.class);

    public SalaryController(SalaryRepository salaryRepository, StaffRepository staffRepository, OrderRepository orderRepository) {
        this.salaryRepository = salaryRepository;
        this.staffRepository = staffRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<Salary> post(@RequestBody GenerateSalaryDTO generateSalaryDTO) throws ParseException {

        var admin = this.staffRepository.findById(generateSalaryDTO.getAdminId());
        var staff = this.staffRepository.findById(generateSalaryDTO.getStaffId());

        logger.info("{} {}", staff, admin);

        if (staff.isEmpty() || admin.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var orders = this.orderRepository.findByDriverAndCreatedAtBetween(staff.get(), generateSalaryDTO.getStartDate(), generateSalaryDTO.getEndDate());

        logger.info("{}", orders.size());

        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var salaryTotal = orders.stream().mapToDouble(e -> (e.getRoute().getRate() * e.getRoute().getDistance()) * 0.3).sum();

        var salary = this.salaryRepository.save(new Salary().setSalary(salaryTotal));

        var salaryWithAttachedEntities = salary.setStaff(staff.get())
                .setAdmin(admin.get())
                .setOrderEntities(orders)
                .setStartDate(generateSalaryDTO.getStartDate())
                .setEndDate(generateSalaryDTO.getEndDate())
                .setCreatedAt(LocalDate.now());

        return ResponseEntity.ok(this.salaryRepository.save(salaryWithAttachedEntities));
    }

    @GetMapping
    public ResponseEntity<List<Salary>> get() {
        return ResponseEntity.ok(this.salaryRepository.findAll());
    }
}
