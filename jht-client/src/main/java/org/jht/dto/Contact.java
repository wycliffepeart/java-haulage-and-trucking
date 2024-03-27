package org.jht.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter()
@Setter()
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Contact {
    private int id;
    private String number;
    private String email;
}
