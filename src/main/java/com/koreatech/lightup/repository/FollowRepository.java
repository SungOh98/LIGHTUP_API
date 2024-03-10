package com.koreatech.lightup.repository;

import com.koreatech.lightup.domain.Follow;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FollowRepository {
    private final EntityManager em;

    public void save(Follow follow) {
        em.persist(follow);
    }

    public Follow findOne(Long id) {
        return em.find(Follow.class, id);
    }

}
