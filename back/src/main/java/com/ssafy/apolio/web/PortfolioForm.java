package com.ssafy.apolio.web;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PortfolioForm {

    private String title;
    private String content;
    private String img;
    private MultipartFile uploadFile;

}
