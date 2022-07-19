package com.ecabs.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripWaypointDto implements Serializable {

    private static final long serialVersionUID = -3751014612825535106L;

    private Long id;
    private String locality;
    private Double latitude;
    private Double longitude;

}
