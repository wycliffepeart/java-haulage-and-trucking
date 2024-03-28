package org.jht.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jht.server.entity.Address;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class OrderRequestBody {
    private long routeId;
    private long driverId;
    private long adminId;
    private long customerId;
    private String invoiceNumber;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Address sourceAddress;
    private Address destinationAddress;
}
