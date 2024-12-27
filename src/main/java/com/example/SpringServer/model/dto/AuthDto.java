package com.example.SpringServer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class AuthDto {
    @Getter
    @Setter
    @Builder
    public static class Request {
        private String email;
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String token;
    }
}
