package com.example.SpringServer.model.dto;

import com.example.SpringServer.model.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class BoardDto {

    @Getter
    @Setter
    public static class Response {

        private Long id;
        private String title;
        private String content;
        private Long authorId;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        public Response(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.authorId = board.getAuthor().getId();
            this.createdAt = board.getCreatedAt();
            this.updatedAt = board.getUpdatedAt();
        }
    }

    @Getter
    @Setter
    @Builder
    public static class Request {
        private String title;
        private String content;
    }
}
