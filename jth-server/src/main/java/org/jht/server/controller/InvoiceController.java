package org.jht.server.controller;


import org.jht.server.entity.Invoice;
import org.jht.server.repository.InvoiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {


    public final InvoiceRepository invoiceRepository;

    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> get() {
        return ResponseEntity.ok(this.invoiceRepository.findAll());
    }

    @GetMapping("filter")
    public ResponseEntity<List<Invoice>> filter(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate, @RequestParam long customerId) {
        return ResponseEntity.ok(this.invoiceRepository.findAllByCustomerIdAndCreatedAtBetween(customerId, startDate, endDate));
    }
}
