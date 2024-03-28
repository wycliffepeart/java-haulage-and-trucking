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
public class GeneratePaySlipBody {

    private long staffId;
    private long adminId;
    private String startDate;
    private String endDate;
}
