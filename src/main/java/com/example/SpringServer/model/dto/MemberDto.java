package com.example.SpringServer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class MemberDto {

    @Getter
    @Setter
    @Builder
    public static class Form {
        private String email;
        private String password;
        private String nickname;
    }

    @Getter
    @Setter
    @Builder
    public static class Response {
        private String email;
        private String nickname;
    }
}
