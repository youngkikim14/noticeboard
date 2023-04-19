package com.example.noticeboard.controller;


import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.BoardResponseDto;
import com.example.noticeboard.entity.Board;
import com.example.noticeboard.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService = new BoardService();

    @PostMapping("/create")
    public String createBoard(@RequestBody BoardRequestDto requestDto){
        return boardService.createBoard(requestDto);
    }

    @GetMapping("/list")
    public List<BoardResponseDto> getBoardList(){
        return boardService.getBoardList();
    }

    @GetMapping("/{id}")
    public BoardResponseDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @PutMapping("/update/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.updateBoard(id, requestDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }

}
