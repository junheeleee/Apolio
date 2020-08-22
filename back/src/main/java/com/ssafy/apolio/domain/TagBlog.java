package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


@Entity
@Getter
@Setter
public class TagBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_blog_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "tag_id")
    @JsonBackReference
    private Tag tag;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "blog_id")
    @JsonBackReference
    private Blog blog;

    //==생성 메서드==//
    public static TagBlog createTagBlog(Tag tag) {
        TagBlog tagBlog = new TagBlog();
        tagBlog.setTag(tag);

        return tagBlog;
    }
}
