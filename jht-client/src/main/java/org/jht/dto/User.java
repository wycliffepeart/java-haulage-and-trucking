package org.jht.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class User {

    private long id;

    private String email;

    private String password;

    private Staff staff;
}
