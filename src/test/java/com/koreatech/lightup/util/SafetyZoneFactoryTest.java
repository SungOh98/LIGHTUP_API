package com.koreatech.lightup.util;

import com.koreatech.lightup.domain.SafetyZoneCategory;
import org.junit.jupiter.api.Test;

import java.util.Map;



class SafetyZoneFactoryTest {

    private SafetyZoneFactory safetyZoneFactory;
    @Test
    public void 안전구역_API생성_테스트() throws Exception{
        //given
        safetyZoneFactory = new SafetyZoneWithAPI(
                "https://api.odcloud.kr/api/15054711/v1/uddi:9097ad1f-3471-42c6-a390-d85b5121816a",
                Map.of(
                        "page", "1",
                        "perPage", "10",
//                        "returnType", "JSON",
                        "serviceKey", "ofR%2F70sxO6qQU6%2FDpTDfxK7bYDqt8qcLfw3Hw7aaBoyG%2Fes%2BlVoxDN842fcM0qAzoaq%2BdG2dZj5pVOhv1%2FAmxw%3D%3D"
                )
        );

        safetyZoneFactory.createSafetyZone(SafetyZoneCategory.POLICE);
        //when

        //then

     }

}