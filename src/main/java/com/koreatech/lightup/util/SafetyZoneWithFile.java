package com.koreatech.lightup.util;

import com.koreatech.lightup.domain.GeneralSafetyZone;
import com.koreatech.lightup.domain.SafetyZone;
import com.koreatech.lightup.domain.SafetyZoneCategory;

import java.util.List;

public class SafetyZoneWithFile extends SafetyZoneFactory {
    @Override
    public void createJsonString() {
    }

    @Override
    protected List<GeneralSafetyZone> parse(SafetyZoneCategory category) {
        return null;
    }


}
