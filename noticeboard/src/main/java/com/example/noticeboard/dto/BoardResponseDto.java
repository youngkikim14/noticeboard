package com.example.noticeboard.dto;

import com.example.noticeboard.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String title;
    private String name;
    private String contents;
    public String msg;

    public BoardResponseDto(Board board) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.contents = contents;
    }
}
