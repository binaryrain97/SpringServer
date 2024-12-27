package com.example.SpringServer.controller;

import com.example.SpringServer.model.dto.MemberDto;
import com.example.SpringServer.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<MemberDto.Response> join(@RequestBody MemberDto.Request request) {
        MemberDto.Response created = memberService.join(request);
        return ResponseEntity.status(HttpStatus.OK).body(created);
    }
}
