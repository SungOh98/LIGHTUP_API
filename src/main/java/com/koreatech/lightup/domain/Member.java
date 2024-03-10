package com.koreatech.lightup.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "followee", cascade = CascadeType.ALL)
    private List<Follow> followingList = new ArrayList<>();

    public void addFollowing(Follow follow) {
        follow.changeFollower(this);
        followingList.add(follow);
    }
}
