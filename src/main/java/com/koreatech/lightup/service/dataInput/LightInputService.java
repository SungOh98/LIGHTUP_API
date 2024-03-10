package com.koreatech.lightup.service.dataInput;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.koreatech.lightup.domain.GeneralSafetyZone;
import com.koreatech.lightup.domain.Location;
import com.koreatech.lightup.domain.SafetyZone;
import com.koreatech.lightup.domain.SafetyZoneCategory;
import com.koreatech.lightup.repository.SafetyZoneRepository;
import com.koreatech.lightup.util.SafetyZoneFactory;
import com.koreatech.lightup.util.SafetyZoneWithAPI;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;

import java.util.*;


@Service
@Transactional
@RequiredArgsConstructor
public class LightInputService {
    private final SafetyZoneRepository safetyZoneRepository;
    private SafetyZoneFactory safetyZoneFactory = new SafetyZoneWithAPI(
            // URL 대입.
            "https://safemap.go.kr/openApiService/data/getSeculightData.do",
            // Params 작성.
            Map.of(
                    "serviceKey" , "4N3DWVS7-4N3D-4N3D-4N3D-4N3DWVS7UH",
                    "pageNo", "1",
                    "numOfRows", "200",
                    "dataType", "JSON"
            )
    );

    public void saveAll() throws Exception {
        List<GeneralSafetyZone> safetyZones = safetyZoneFactory.createSafetyZone(SafetyZoneCategory.LIGHT);
        for (SafetyZone safetyZone : safetyZones) {
            safetyZoneRepository.save(safetyZone);
        }
    }







}
