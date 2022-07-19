package com.ecabs.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto implements Serializable {

    private static final long serialVersionUID = -2840328904858648777L;

    private String id;
    private String passengerName;
    private String passengerContactNumber;
    private LocalDateTime pickupTime;
    private boolean asap;
    private long waitingTime;
    private long numberOfPassengers;
    private BigDecimal price;
    private double rating;
    private LocalDateTime createdOn;
    private LocalDateTime lastModifiedOn;
    private List<TripWaypointDto> tripWaypoints;
}
