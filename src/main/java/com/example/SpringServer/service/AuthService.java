package com.example.SpringServer.service;

import com.example.SpringServer.jwt.JwtToken;
import com.example.SpringServer.jwt.JwtUtil;
import com.example.SpringServer.model.dto.AuthDto;
import com.example.SpringServer.model.entity.Member;
import com.example.SpringServer.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public JwtToken login(AuthDto.Request loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        Member member = memberRepository.findByEmail(email).orElseThrow();
        if(!passwordEncoder.matches(password, member.getPassword())) {
            throw new BadCredentialsException("password incorrect");
        }
        String accessToken = jwtUtil.generateToken(email);
        return JwtToken.builder()
                .accessToken(accessToken)
                .build();
    }
}
