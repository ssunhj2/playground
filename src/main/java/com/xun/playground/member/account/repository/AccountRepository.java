package com.xun.playground.member.account.repository;

import com.xun.playground.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 회원계정 repository
 */
public interface AccountRepository extends JpaRepository<MemberEntity, String> {
    // 회원 탈퇴
    @Modifying
    @Query("UPDATE MemberEntity m SET m.isLogin = 'N' WHERE m.memberNo = :memberNo")
    int leaveAccount(@Param("memberNo") String memberNo);
}
