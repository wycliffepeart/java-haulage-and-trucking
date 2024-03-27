package org.jht.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class CreateOrderDTO {
    private String invoiceNumber;
    private String createdAt;
    private String updatedAt;
    private long routeId;
    private long driverId;
    private long adminId;
    private long customerId;
    private Address sourceAddress;
    private Address destinationAddress;
}
