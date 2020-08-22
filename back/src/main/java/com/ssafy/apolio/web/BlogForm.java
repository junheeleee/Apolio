package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogForm {
    private long user_id;
    private String title;
    private String content;
    private String description;
    private long tagId;
    private String img;
}
