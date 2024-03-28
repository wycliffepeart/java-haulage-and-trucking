package org.jht.server.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class GenerateSalaryDTO {

    private long staffId;

    private long adminId;

    private LocalDate startDate;

    private LocalDate endDate;
}
