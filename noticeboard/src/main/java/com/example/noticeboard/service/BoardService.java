package com.example.noticeboard.service;

import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.BoardResponseDto;
import com.example.noticeboard.entity.Board;
import com.example.noticeboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public String createBoard(BoardRequestDto requestDto){

        Board board = new Board(requestDto);
        boardRepository.save(board);
        return "게시물 저장 완료!";
    }


    public List<BoardResponseDto> getBoardList(){
        return boardRepository.getBoardList();
    }


    public BoardResponseDto getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("선택한 게시물이 존재하지 않습니다")
        );
        return new BoardResponseDto(board);
    }

    @Transactional
    public BoardResponseDto updateBoard(Long id,BoardRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("선택한 게시물이 존재하지 않습니다")
        );
        boardRepository.update(requestDto);
        return new BoardResponseDto(board);
    }

    public String deleteBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("선택한 게시물이 존재하지 않습니다")
        );
        boardRepository.delete(id);
        return "게시물이 삭제되었습니다";
        }

}