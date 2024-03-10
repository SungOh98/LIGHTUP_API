package com.koreatech.lightup.service;

import com.koreatech.lightup.domain.Follow;
import com.koreatech.lightup.domain.Member;
import com.koreatech.lightup.dto.MemberDto;
import com.koreatech.lightup.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(MemberDto memberDto) {
        Member member = new Member(memberDto.getName(), memberDto.getEmail(), memberDto.getPassword());
        memberRepository.save(member);
        return member.getId();
    }

    @Transactional(readOnly = true)
    public void validDuplicate(Member member) {
        List<Member> findMembers = memberRepository.findAllByName(member.getName());
        if (!findMembers.isEmpty()) throw new IllegalStateException("동일한 이름의 회원이 존재합니다.");
    }

    public void follow(Long id, String name) {
        Member follower = memberRepository.findOne(id);
        Member followee = memberRepository.findAllByName(name).get(0);

        follower.addFollowing(new Follow(followee));

    }

}
