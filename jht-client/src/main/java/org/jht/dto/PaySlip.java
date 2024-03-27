package org.jht.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter()
@Setter()
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class PaySlip {

    private final int id;

    private final Date startDate;

    private final Date endDate;

    private final double salary;

    private Date createdAt;

    private Date updatedAt;

    private final Staff staff;

    private final Staff admin;
}
