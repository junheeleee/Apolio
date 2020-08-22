package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    private String name;


    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TagBlog> tagBlogs = new ArrayList<>();

}
