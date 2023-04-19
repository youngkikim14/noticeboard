package com.example.noticeboard.repository;

import com.example.noticeboard.dto.BoardResponseDto;
import com.example.noticeboard.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BoardRepository {
    private static final Map<Long, Board> table = new HashMap<>();
    private static long ID;

    public String createBoard(Board board) {

        board.setId(++ID);
        table.put(ID, board);

        return "게시글 저장 완료!";

    }

    public List<BoardResponseDto> getBoardList() {
        return table.values().stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }


    public Board getBoard(Long id) {
        return table.get(id);
    }


    public void deleteBoard(Long id) {
        table.remove(id);
    }
}
