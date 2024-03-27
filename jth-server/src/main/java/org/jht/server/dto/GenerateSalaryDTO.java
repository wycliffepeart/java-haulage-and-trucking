package org.jht.server.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class GenerateSalaryDTO {

    private int staffId;

    private int adminId;

    private Date startDate;

    private Date endDate;
}
