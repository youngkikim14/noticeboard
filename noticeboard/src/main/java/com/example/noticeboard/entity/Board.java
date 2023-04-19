package com.example.noticeboard.entity;

import com.example.noticeboard.dto.BoardRequestDto;
import lombok.Getter;

@Getter
public class Board {
    private Long id;
    private String title;
    private String name;
    private String contents;
    private String password;

    public void setId(Long id) {
        this.id = id;
    }

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
    }

    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
