package com.koreatech.lightup.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Follow {
    public Follow(Member followee) {
        this.followee = followee;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "to_member_id")
    private Member followee;

    @ManyToOne
    @JoinColumn(name = "from_member_id")
    private Member follower;

    // 연관 관계 편의 메소드 //
    public void changeFollower(Member follower) {
        this.follower = follower;
    }


}
