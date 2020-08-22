package com.ssafy.apolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsApiDto {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urltoimage;
    private String publishedAt;
}
