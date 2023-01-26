package com.xun.playground.member.join.repository;

import com.xun.playground.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 회원가입 Repository
 */
public interface JoinRepository extends JpaRepository<MemberEntity, String> {
    // 중복검사를 위해 login id 로 검색
    MemberEntity findByLoginId(String loginId);
}
