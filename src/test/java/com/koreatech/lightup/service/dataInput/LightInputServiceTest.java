package com.koreatech.lightup.service.dataInput;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LightInputServiceTest {

    @Autowired
    LightInputService lightInputService;

    @Test
    @Rollback(value = false)
    public void 욫청테스트() throws Exception {
        //given

        //when


        //then


    }

    @Test
    @Rollback(value = false)
    public void 데이터받아와넣기() throws Exception{
        //given

        //when

        //then

     }
}