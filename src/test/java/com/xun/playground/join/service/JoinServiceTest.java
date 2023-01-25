package com.xun.playground.join.service;

import com.xun.playground.common.CommonUtils;
import com.xun.playground.join.dto.JoinDTO;

import static org.assertj.core.api.Assertions.assertThat;

import com.xun.playground.join.entity.JoinEntity;
import com.xun.playground.join.repository.JoinRepository;
import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

/**
 * 회원가입 테스트코드
 */
@SpringBootTest
@Transactional
public class JoinServiceTest {
    @Autowired JoinService joinService;
    @Autowired JoinRepository joinRepository;

    @Test
    void 회원정보_저장() throws NoSuchAlgorithmException {
        // given
        String password = "testPassword1";
        String newPw = CommonUtils.encryption(password);

        String loginId = "12dupTestUser1234";
        // id 중복검사
        boolean isUse = joinService.chkDupId(loginId);

        assertThat(isUse).isEqualTo(true);
        if(!isUse) return; // 중복검사에서 실패하면 테스트 stop

        // when
        JoinDTO dummyDto =  new JoinDTO(loginId, newPw, "테스트유저", "010-1234-5678", "test@example.com", "testUser");
        String result = joinService.saveMember(dummyDto);

        // 저장한 멤버를 DB에서 조회
        JoinEntity entity = joinRepository.findByLoginId(loginId);

        // then
        assertEquals(result, "success");
        assertEquals(dummyDto.getLoginId(), entity.getLoginId());
    }

    @Test
    void 아이디_중복검사(){
        boolean isException1 = true;

        // Given
        String loginId = "12dupTestUser1234";
        //사용자1
        JoinDTO member1 =  new JoinDTO();
        member1.setLoginId(loginId);
        // 사용자2
        JoinDTO member2 =  new JoinDTO();
        member2.setLoginId(loginId);

        // when
        joinService.saveMember(member1);

        // 서비스 테스트
        boolean isException2 = joinService.chkDupId(loginId);

        try {
            joinService.saveMember(member2);
        } catch(IllegalStateException e){
            isException1 = false;
        } catch(Exception e){
            isException1 = false;
        }


        // then
        assertThat(isException1).isEqualTo(isException2);
    }

}
