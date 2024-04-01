package org.jht.server.repository;

import org.jht.server.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    public List<Invoice> findAllByCustomerIdAndCreatedAtBetween(Long id, LocalDate start, LocalDate endDate);
}
