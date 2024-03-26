package org.jht.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter()
@Setter()
@AllArgsConstructor
@Accessors(chain = true)
public class Address {
    private final int id;
    private final String lineOne;
    private final String lineTwo;
    private final String parish;
    private final String postOffice;
}
