package com.xun.playground.join.service;

import com.xun.playground.common.CommonUtils;
import com.xun.playground.member.dto.MemberDTO;

import static org.assertj.core.api.Assertions.assertThat;

import com.xun.playground.member.entity.MemberEntity;
import com.xun.playground.member.join.repository.JoinRepository;
import com.xun.playground.member.join.service.JoinService;

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
    @Autowired
    JoinService joinService;
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
        MemberDTO dummyDto =  new MemberDTO(loginId, newPw, "테스트유저", "010-1234-5678", "test@example.com", "주소입니다.", "취미입니다.", "testUser");
        String result = joinService.saveMember(dummyDto);

        // 저장한 멤버를 DB에서 조회
        MemberEntity entity = joinRepository.findByLoginId(loginId);

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
        MemberDTO member1 =  new MemberDTO();
        member1.setLoginId(loginId);
        // 사용자2
        MemberDTO member2 =  new MemberDTO();
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
