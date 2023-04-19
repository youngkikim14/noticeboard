package com.example.noticeboard.controller;


import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.BoardResponseDto;
import com.example.noticeboard.entity.Board;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/board")
public class BoardController {
    
    @PostMapping("/create")
    public String createBoard(@RequestBody BoardRequestDto requestDto){

    }

    @GetMapping("/list")
    public List<BoardResponseDto> getBoardList(){
    }

    @GetMapping("/{id}")
    public BoardResponseDto getBoard(@PathVariable Long id) {
    }

    @PutMapping("/update/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id) {
    }

}
