package com.example.SpringServer.repository;

import com.example.SpringServer.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByEmail(String email);
    Boolean existsByNickname(String nickname);
}
