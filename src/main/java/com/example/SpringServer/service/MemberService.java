package com.example.SpringServer.service;

import com.example.SpringServer.model.dto.MemberDto;
import com.example.SpringServer.model.entity.Member;
import com.example.SpringServer.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberDto.Response join(MemberDto.Form form) {
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        Member member = Member.builder()
                .email(form.getEmail())
                .password(encodedPassword)
                .nickname(form.getNickname())
                .build();
        Member created = memberRepository.save(member);
        return MemberDto.Response.builder()
                .email(created.getEmail())
                .nickname(created.getNickname())
                .build();
    }
}
