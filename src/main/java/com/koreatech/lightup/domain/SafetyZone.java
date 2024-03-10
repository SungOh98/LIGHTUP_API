package com.koreatech.lightup.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class SafetyZone {
    public SafetyZone(String name, Location location) {
        this.name = name;
        this.location = location;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "safety_zone_id")
    private Long id;
    private String name;
    @Embedded
    private Location location;
}
