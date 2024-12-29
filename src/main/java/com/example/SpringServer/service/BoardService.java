package com.example.SpringServer.service;

import com.example.SpringServer.model.dto.BoardDto;
import com.example.SpringServer.model.entity.Board;
import com.example.SpringServer.model.entity.Member;
import com.example.SpringServer.repository.BoardRepository;
import com.example.SpringServer.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public BoardDto.Response getDetail(Long boardId) {
        Board board = this.boardRepository.findById(boardId).orElseThrow(
                () -> new RuntimeException("board not found")
        );
        return new BoardDto.Response(board);
    }

    public List<BoardDto.Response> getBoardList() {
        List<Board> boardList = this.boardRepository.findAll();
        return boardList.stream()
                .map(BoardDto.Response::new)
                .toList();
    }

    public BoardDto.Response post(BoardDto.Request request, Long authorId) {
        Member author = this.memberRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("author not exists"));
        Board board = new Board(null, request.getTitle(), request.getContent(), author, LocalDateTime.now(), null);
        Board created = boardRepository.save(board);
        return new BoardDto.Response(created);
    }

    public boolean delete(Long boardId, Long userId) {
        Board target = this.boardRepository.findById(boardId).orElseThrow(
                () -> new RuntimeException("board not found")
        );
        if(!Objects.equals(userId, target.getId())) return false;
        this.boardRepository.delete(target);
        return true;
    }
}
