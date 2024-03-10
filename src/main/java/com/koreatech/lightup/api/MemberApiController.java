package com.koreatech.lightup.api;

import com.koreatech.lightup.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("/following")
    public ResponseEntity<Map<String, String>> following(@RequestBody FollowingDto followingDto) {
        Map<String, String> resultMap = new HashMap<>();
        HttpStatus httpStatus;
        try {
            memberService.follow(followingDto.getFollowerId(), followingDto.getFolloweeName());
            resultMap.put("message", "success!");
            httpStatus = HttpStatus.OK;

        }catch (Exception e) {
            resultMap.put("message", "FAILED!!");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, httpStatus);

    }

    @Data
    private static class FollowingDto {
        Long followerId;
        String followeeName;
    }


}
