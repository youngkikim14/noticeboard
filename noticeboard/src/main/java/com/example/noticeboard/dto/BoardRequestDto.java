package com.example.noticeboard.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String title;
    private String name;
    private String contents;
    private String password;

}
