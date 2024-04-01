package org.jht.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Invoice {

    private long id;

    private double total;

    private String createdAt;

    private Customer customer;
}
