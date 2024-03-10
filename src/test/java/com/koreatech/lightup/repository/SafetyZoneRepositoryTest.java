package com.koreatech.lightup.repository;

import com.koreatech.lightup.domain.GeneralSafetyZone;
import com.koreatech.lightup.domain.Location;
import com.koreatech.lightup.domain.SafetyZone;
import com.koreatech.lightup.domain.SafetyZoneCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SafetyZoneRepositoryTest {

    @Autowired SafetyZoneRepository safetyZoneRepository;

    @Test
    public void 삽입테스트() throws Exception{
        //given
        SafetyZone light = new GeneralSafetyZone(
                "방범등",
                new Location(new BigDecimal("1231"), new BigDecimal("214231"), null),
                SafetyZoneCategory.LIGHT
        );

        //when
        safetyZoneRepository.save(light);
        //then

     }

}