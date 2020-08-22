package com.ssafy.apolio.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommunityAllDto {
    String Email;
    String Title;
    LocalDateTime create_at;
    String Content;
}
