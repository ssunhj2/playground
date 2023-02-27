package com.xun.playground.member.join.service;

import com.xun.playground.common.util.CommonUtils;
import com.xun.playground.member.dto.MemberDTO;
import com.xun.playground.member.entity.MemberEntity;
import com.xun.playground.member.join.repository.JoinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

/**
 * 회원가입 서비스
 */
@Transactional
@Service
public class JoinService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final JoinRepository joinRepository;

    @Autowired
    public JoinService(JoinRepository joinRepository){
        this.joinRepository = joinRepository;
    }

    /**
     * 회원정보 저장
     * @param joinDto
     */
    public String saveMember(MemberDTO joinDto) {
        // 아이디 중복체크
        String loginId = joinDto.getLoginId();
        if(!chkDupId(loginId)) return "DUP_ID";

        // 비밀번호 암호화
        String password = joinDto.getPassword();
        try{
            String newPassword = CommonUtils.encryption(password);

            joinDto.setPassword(newPassword); // 암호화된 PW
            joinDto.setEnterBy(joinDto.getLoginId()); // enterBy
            joinDto.setIsLogin("Y");

            MemberEntity entity = joinDto.toEntity();
            // DB에 저장
            joinRepository.save(entity);

            return "SUCCESS";

        } catch(NoSuchAlgorithmException e){
            logger.error(e.getMessage());
            return "FAIL";
        } catch(Exception e){
            logger.error(e.getMessage());
            return "FAIL";
        }

    }

    /**
     * loginId 중복체크
     * @param loginId
     * @return
     */
    public boolean chkDupId(String loginId){
        MemberEntity joinEntity = joinRepository.findByLoginId(loginId);
        // 검색된 결과가 없는 경우
        if(joinEntity == null) return true;

        return false;
    }



}
