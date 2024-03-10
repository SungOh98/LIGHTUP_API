package com.koreatech.lightup.api;

import com.koreatech.lightup.repository.SafetyZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class DataInputApiController {
    private final SafetyZoneRepository safetyZoneRepository;




}
