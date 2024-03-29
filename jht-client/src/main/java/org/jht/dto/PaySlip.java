package org.jht.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

@Getter()
@Setter()
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class PaySlip {

    private final int id;

    private final LocalDate startDate;

    private final LocalDate endDate;

    private final double salary;

    private LocalDate createdAt;

    private final Staff staff;

    private final Staff admin;
}
