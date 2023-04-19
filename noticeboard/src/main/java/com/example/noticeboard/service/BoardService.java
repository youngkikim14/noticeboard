package com.example.noticeboard.service;

import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.BoardResponseDto;
import com.example.noticeboard.entity.Board;
import com.example.noticeboard.repository.BoardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BoardService {

    private final BoardRepository boardRepository = new BoardRepository();

    public String createBoard(BoardRequestDto requestDto){

        Board board = new Board(requestDto);
        return boardRepository.createBoard(board);
    }


    public List<BoardResponseDto> getBoardList(){
        return boardRepository.getBoardList();
    }


    public BoardResponseDto getBoard(Long id) {
        Board board = boardRepository.getBoard(id);

        if(board != null){
            return new BoardResponseDto(board);
        } else {
            return new BoardResponseDto();
        }
    }


    public BoardResponseDto updateBoard(Long id,BoardRequestDto requestDto){
        Board board = boardRepository.getBoard(id);

        if(board != null){
            board.update(requestDto);
            return new BoardResponseDto(board);
        } else {
            return new BoardResponseDto();
        }
    }

    public String deleteBoard(Long id) {

        Board board = boardRepository.getBoard(id);

        if (board != null) {
            boardRepository.deleteBoard(id);
            return "게시물이 삭제되었습니다";
        } else {
            return "삭제 할 대상이 없습니다";
        }
    }
}
