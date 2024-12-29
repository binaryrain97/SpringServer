package com.example.SpringServer.controller;

import com.example.SpringServer.model.dto.BoardDto;
import com.example.SpringServer.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/detail/{boardId}")
    public ResponseEntity<BoardDto.Response> getDetail(@PathVariable Long boardId) {
        BoardDto.Response response = this.boardService.getDetail(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.Response>> getList() {
        List<BoardDto.Response> list = this.boardService.getBoardList();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/new")
    public ResponseEntity<BoardDto.Response> post(@RequestBody BoardDto.Request request, Authentication authentication) {
        if(authentication == null || !authentication.isAuthenticated())
            throw new RuntimeException("authentication error");
        BoardDto.Response response = this.boardService.post(request, Long.parseLong(authentication.getName()));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<String> delete(@PathVariable Long boardId, Authentication authentication) {
        if(authentication == null || !authentication.isAuthenticated())
            throw new RuntimeException("authentication error");
        boolean result = this.boardService.delete(boardId, Long.parseLong(authentication.getName()));
        return ResponseEntity.status(HttpStatus.OK).body(result ? "success" : "failure");
    }
}
