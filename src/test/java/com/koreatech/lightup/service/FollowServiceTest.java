package com.koreatech.lightup.service;

import com.koreatech.lightup.domain.Follow;
import com.koreatech.lightup.domain.Member;
import com.koreatech.lightup.dto.MemberDto;
import com.koreatech.lightup.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class FollowServiceTest {

    @Autowired FollowService followService;
    @PersistenceContext EntityManager em;
    @Autowired MemberService memberService;

    @Autowired
    MemberRepository memberRepository;
    @Test
    @Transactional
    @Rollback(value = false)
    public void 팔로우_추가() throws Exception{
        //given
        MemberDto memberDtoA = new MemberDto("정성오", "tryjso@gmail.com", "123");
        MemberDto memberDtoB = new MemberDto("김형겸", "pkqwaszx@gmail.com", "123");
        MemberDto memberDtoC = new MemberDto("송민상", "31n5ang@gmail.com", "123");

        Long idA = memberService.join(memberDtoA);
        Long idB = memberService.join(memberDtoB);
        Long idC = memberService.join(memberDtoC);

        Member memberA = memberRepository.findOne(idA);
        Member memberB = memberRepository.findOne(idB);
        Member memberC = memberRepository.findOne(idC);

        //when
        // 성오 -> 형겸, 민상
        // 형겸 -> 성오, 민상
        // 민상 -> 형겸
        memberA.addFollowing(new Follow(memberB));
        memberA.addFollowing(new Follow(memberC));

        memberB.addFollowing(new Follow(memberA));
        memberB.addFollowing(new Follow(memberC));

        memberC.addFollowing(new Follow(memberA));


        //then
        for (Follow follow : memberA.getFollowingList()) {
            System.out.println(follow.getFollowee().getName());
        }
        System.out.println("==========================");
        for (Follow follow : memberB.getFollowingList()) {
            System.out.println(follow.getFollowee().getName());
        }
        System.out.println("==========================");
        for (Follow follow : memberC.getFollowingList()) {
            System.out.println(follow.getFollowee().getName());
        }
        System.out.println("==========================");

        memberA.getFollowingList().remove(1);


    }

}