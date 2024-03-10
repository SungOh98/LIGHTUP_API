package com.koreatech.lightup.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@DiscriminatorValue(value = "custom")
@Getter
public class CustomSafetyZone extends SafetyZone{
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
