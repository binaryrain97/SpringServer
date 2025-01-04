package com.example.SpringServer.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class JoinDto {

    @Getter
    @Setter
    public static class EmailCheckRequest {
        private String email;
    }

    @Getter
    @Setter
    @Builder
    public static class EmailCheckResponse {
        private String email;
        private boolean duplicated;
    }

    @Getter
    @Setter
    public static class NicknameCheckRequest {
        private String nickname;
    }

    @Getter
    @Setter
    @Builder
    public static class NicknameCheckResponse {
        private String nickname;
        private boolean duplicated;
    }
}
