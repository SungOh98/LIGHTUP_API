package com.koreatech.lightup.service;

import com.koreatech.lightup.repository.SafetyZoneRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SafetyZoneService {
    private final SafetyZoneRepository safetyZoneRepository;



}
