package com.koreatech.lightup.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue(value = "general")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneralSafetyZone extends SafetyZone{
    @Enumerated(EnumType.STRING)
    private SafetyZoneCategory category;

    public GeneralSafetyZone(String name, Location location, SafetyZoneCategory category) {
        super(name, location);
        this.category = category;
    }
}
