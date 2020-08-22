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
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long id;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Heart> hearts = new ArrayList<>();

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TagBlog> tagBlogs = new ArrayList<>();

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    private String title;

    private String content;

    private String description;

    private String img_thumb;

    private LocalDateTime create_date;

    //==연관관계 메서드==//
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setBlog(this);
    }

    public void addHeart(Heart heart) {
        hearts.add(heart);
        heart.setBlog(this);
    }

    public void addTagBlog(TagBlog tagBlog) {
        tagBlogs.add(tagBlog);
        tagBlog.setBlog(this);
    }

    //==생성 메서드==//
    public static Blog createBlog(User user, String title, String content, String description,  String img_thumb, TagBlog... tagBlogs) {
        Blog blog = new Blog();

        blog.setTitle(title);
        blog.setContent(content);
        blog.setDescription(description);
        blog.setImg_thumb(img_thumb);
        blog.setCreate_date(LocalDateTime.now());
        blog.setUser(user);
        for (TagBlog tagBlog : tagBlogs){
            blog.addTagBlog(tagBlog);
        }

        return blog;
    }

}
