package org.jht.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter()
@Setter()
@Accessors(chain = true)
public class Route {

    private int id;

    private String route;

    private int distance;

    private double rate;

    private String description;

    private String createdAt;

    private String updatedAt;

}
