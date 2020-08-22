package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ssafy.apolio.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Heart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heart_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "blog_id")
    @JsonBackReference
    private Blog blog;

//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "community_id")
//    @JsonBackReference
//    private Community community;

//    @Enumerated(EnumType.STRING)
//    private HeartStatus status;// 하트상태 [HEART, CANCEL]

}
