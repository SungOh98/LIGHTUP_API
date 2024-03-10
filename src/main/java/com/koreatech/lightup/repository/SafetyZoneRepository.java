package com.koreatech.lightup.repository;

import com.koreatech.lightup.domain.SafetyZone;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SafetyZoneRepository {
    private final EntityManager em;

    public void save(SafetyZone safetyZone) {
        em.persist(safetyZone);
    }

    public SafetyZone findOne(Long id) {return em.find(SafetyZone.class, id);}
}
