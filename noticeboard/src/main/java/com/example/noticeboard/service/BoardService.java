package com.example.noticeboard.service;

import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.BoardResponseDto;
import com.example.noticeboard.entity.Board;
import com.example.noticeboard.repository.BoardRepository;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;


    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    @Transactional
    public String createBoard(BoardRequestDto requestDto){

        Board board = new Board(requestDto);
        boardRepository.save(board);
        return "게시물 저장 완료!";
    }
    @Transactional
    public BoardResponseDto getBoard(Long id) {
        Board board = checkid(id);
        return new BoardResponseDto(board);
    }

    @Transactional
    public BoardResponseDto updateBoard(Long id,BoardRequestDto requestDto){
        Board board = checkid(id);
        if (board.getPassword().equals(requestDto.getPassword())){
            board.update(requestDto);
        }

        return new BoardResponseDto(board);
    }
    @Transactional
    public String deleteBoard(Long id) {

        Board board = checkid(id);
        boolean isPasswordMatched = board.getPassword().equals("password");
        if (isPasswordMatched) {
            boardRepository.delete(board);
        }
        return "게시물이 삭제되었습니다";
        }

    private Board checkid(Long id) {
        return boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("선택한 게시물이 존재하지 않습니다")
        );

    }

}