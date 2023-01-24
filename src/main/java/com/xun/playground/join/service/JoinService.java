package com.xun.playground.join.service;

import com.xun.playground.common.CommonUtils;
import com.xun.playground.join.dto.JoinDTO;
import com.xun.playground.join.entity.JoinEntity;
import com.xun.playground.join.repository.JoinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

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
    public String saveMember(JoinDTO joinDto) {
        // 비밀번호 암호화
        String password = joinDto.getPassword();
        try{
            String newPassword = CommonUtils.encryption(password);

            joinDto.setPassword(newPassword); // 암호화된 PW
            joinDto.setEnterBy(joinDto.getLoginId()); // enterBy

            JoinEntity entity = joinDto.toEntity();
            // DB에 저장
            joinRepository.save(entity);

            return "success";

        } catch(NoSuchAlgorithmException e){
            logger.error(e.getMessage());
            return "fail";
        } catch(Exception e){
            logger.error(e.getMessage());
            return "fail";
        }

    }



}
