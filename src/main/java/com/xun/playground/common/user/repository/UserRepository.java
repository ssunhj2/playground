package com.xun.playground.common.user.repository;

import com.xun.playground.common.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    // loginId로 회원검색
    UserEntity findByLoginId(String loginId);
}
