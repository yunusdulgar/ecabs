package com.ecabs.interview.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TripWaypoint implements Serializable {

    private static final long serialVersionUID = 3329639725644944735L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String locality;
    private Double latitude;
    private Double longitude;
}
