package com.ecabs.interview.model;

import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Booking implements Serializable {

    private static final long serialVersionUID = -2804914782593535984L;

    @Id
    @EqualsAndHashCode.Include
    private String id;
    @Column(nullable = false)
    private String passengerName;
    @Column(nullable = false)
    private String passengerContactNumber;
    private LocalDateTime pickupTime;
    private boolean asap;
    private long waitingTime;
    private long numberOfPassengers;
    private BigDecimal price;
    private double rating;
    private LocalDateTime createdOn;
    private LocalDateTime lastModifiedOn;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "booking_waypoints",
            joinColumns =
            @JoinColumn(name = "booking_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "waypoint_id", referencedColumnName = "id")
    )
    private List<TripWaypoint> tripWaypoints;
}
