package com.koreatech.lightup.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koreatech.lightup.domain.GeneralSafetyZone;
import com.koreatech.lightup.domain.SafetyZoneCategory;

import java.util.List;

public abstract class SafetyZoneFactory {
    protected ObjectMapper mapper = new ObjectMapper();
    protected StringBuilder jsonString;
    protected abstract void createJsonString() throws Exception;
    protected abstract List<GeneralSafetyZone> parse(SafetyZoneCategory category) throws JsonProcessingException;

    public final List<GeneralSafetyZone> createSafetyZone(SafetyZoneCategory category) throws Exception {
        createJsonString();
        return parse(category);

    }

}
