package com.xun.playground.member.account.repository;

import com.xun.playground.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<MemberEntity, String> {
}
