package org.jht.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter()
@Setter()
@AllArgsConstructor
@Accessors(chain = true)
public class Contact {
    private final int id;
    private final String number;
    private final String email;
}
