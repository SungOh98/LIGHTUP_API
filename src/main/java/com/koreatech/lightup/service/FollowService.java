package com.koreatech.lightup.service;

import com.koreatech.lightup.repository.FollowRepository;
import com.koreatech.lightup.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class FollowService {
    private final MemberRepository memberRepository;
    private final FollowRepository followRepository;

}
