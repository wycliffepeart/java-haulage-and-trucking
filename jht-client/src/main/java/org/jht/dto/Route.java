package org.jht.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter()
@Setter()
@AllArgsConstructor
@Accessors(chain = true)
public class Route {

    private final int id;

    private final String description;

    private final String sourceParish;

    private final String destinationParish;

    private final int distance;

    private final double rate;

    private final String createdAt;

    private final String updatedAt;

}
