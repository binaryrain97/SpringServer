package com.example.SpringServer.controller;

import com.example.SpringServer.model.dto.JoinDto;
import com.example.SpringServer.model.dto.MemberDto;
import com.example.SpringServer.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/join")
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/new")
    public ResponseEntity<MemberDto.Response> join(
            @RequestBody MemberDto.Request request) {
        MemberDto.Response created = joinService.join(request);
        return ResponseEntity.status(HttpStatus.OK).body(created);
    }

    @PostMapping("/check-email")
    public ResponseEntity<JoinDto.EmailCheckResponse> checkEmailDuplicated(
            @RequestBody JoinDto.EmailCheckRequest request) {
        JoinDto.EmailCheckResponse emailCheckResponse = this.joinService.checkEmailDuplicated(request.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(emailCheckResponse);
    }

    @PostMapping("/check-nickname")
    public ResponseEntity<JoinDto.NicknameCheckResponse> checkNicknameDuplicated(
            @RequestBody JoinDto.NicknameCheckRequest request) {
        JoinDto.NicknameCheckResponse nicknameCheckResponse = this.joinService.checkNicknameDuplicated(request.getNickname());
        return ResponseEntity.status(HttpStatus.OK).body(nicknameCheckResponse);
    }
}
