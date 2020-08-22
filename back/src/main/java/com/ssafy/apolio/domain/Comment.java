package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ssafy.apolio.domain.user.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import static javax.persistence.FetchType.LAZY;


@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;


    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "blog_id")
    @JsonBackReference
    private Blog blog;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "community_id")
    @JsonBackReference
    private Community community;

    private Long parent;//댓글인지, 대댓글인지 구별하는 column(parent가 null이면 댓글, 아니면은 대댓글)

    private Long comment_group;//댓글별로 그룹을 지정하여서 정렬할 때 사용

    private String content;

    private LocalDateTime create_date;


    // 댓글 작성 메소드
    public static Comment createCommentBlog(User user, Blog blog, String content){
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setBlog(blog);
        comment.setContent(content);//댓글 내용
        comment.setCreate_date(LocalDateTime.now());//댓글 작성 시간
        user.addComment(comment);
        blog.addComment(comment);
        return comment;

    }

    public static Comment createCommentCommunity(User user, Community community, String content){
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setCommunity(community);
        comment.setContent(content);//댓글 내용
        comment.setCreate_date(LocalDateTime.now());//댓글 작성 시간
        user.addComment(comment);
        community.addComment(comment);
        return comment;

    }

    //대댓글 작성 메소드
    public static Comment createReplyBlog(Long parent, User user, Blog blog, String content){
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setBlog(blog);
        comment.setContent(content);//대댓글 내용
        comment.setCreate_date(LocalDateTime.now());//대댓글 작성 시간
        comment.setParent(parent);//대댓글의 부모 댓글
        comment.setComment_group(parent);
        user.addComment(comment);
        blog.addComment(comment);
        return comment;

    }

    public static Comment createReplyCommunity(Long parent, User user, Community community, String content){
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setCommunity(community);
        comment.setContent(content);//대댓글 내용
        comment.setCreate_date(LocalDateTime.now());//대댓글 작성 시간
        comment.setParent(parent);//대댓글의 부모 댓글
        comment.setComment_group(parent);
        user.addComment(comment);
        community.addComment(comment);
        return comment;

    }

}
