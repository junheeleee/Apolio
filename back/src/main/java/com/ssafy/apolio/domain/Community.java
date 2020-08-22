package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ssafy.apolio.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_id")
    private Long id;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

//    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Heart> hearts = new ArrayList<>();

    private String title;

    private String content;

    private LocalDateTime create_date;

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setCommunity(this);
    }

//    public void addHeart(Heart heart) {
//        hearts.add(heart);
//        heart.setCommunity(this);
//    }

    public static Community createCommunity(String title, String content, User user) {
        Community community = new Community();
        community.setTitle(title);
        community.setContent(content);
        community.setUser(user);
        community.setCreate_date(LocalDateTime.now());
        return community;
    }
}
