package com.koreatech.lightup.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.math.BigDecimal;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@AllArgsConstructor
public class Location {
    @Column(precision=18, scale = 10)
    private BigDecimal longitude;
    @Column(precision=18, scale = 10)
    private BigDecimal latitude;
    private String street;
}
