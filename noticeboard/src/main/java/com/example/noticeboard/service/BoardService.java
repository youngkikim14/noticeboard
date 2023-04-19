package com.example.noticeboard.service;

import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.BoardResponseDto;
import com.example.noticeboard.entity.Board;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BoardService {

    private static final Map<Long, Board> table = new HashMap<>();
    private static long ID;

    public String createBoard(BoardRequestDto requestDto){
        //데이터 저장
        Board board = new Board(requestDto);

        board.setId(++ID);

        table.put(ID, board);

        return "게시글 저장 완료!";
    }


    public List<BoardResponseDto> getBoardList(){
        return table.values().stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }


    public BoardResponseDto getBoard(Long id) {
        Board board = table.get(id);

        if(board != null){
            return new BoardResponseDto(board);
        } else {
            return new BoardResponseDto();
        }
    }


    public BoardResponseDto updateBoard(Long id,BoardRequestDto requestDto){
        Board board = table.get(id);

        if(board != null){
            board.update(requestDto);
            return new BoardResponseDto(board);
        } else {
            return new BoardResponseDto();
        }
    }

    public String deleteBoard(Long id) {

        Board board = table.get(id);

        if (board != null) {
            table.remove(id);
            return "게시물이 삭제되었습니다";
        } else {
            return "삭제 할 대상이 없습니다";
        }
    }
}
