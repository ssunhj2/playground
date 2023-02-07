package com.xun.playground.login.service;


import com.xun.playground.common.util.CommonUtils;
import com.xun.playground.common.user.dto.UserDTO;
import com.xun.playground.common.user.entity.UserEntity;
import com.xun.playground.common.user.repository.UserRepository;
import com.xun.playground.login.dto.LoginDTO;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

/**
 * 로그인 서비스
 */
@Transactional
@Service
public class LoginService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * 로그인
     * @param loginDTO
     * @return
     */
    public UserDTO login(LoginDTO loginDTO) {
        if(loginDTO == null) return null;

        try{
            String password = loginDTO.getPassword();
            String chkPw = CommonUtils.encryption(password); // 비밀번호 암호화

            UserEntity entity = userRepository.findByLoginId(loginDTO.getLoginId());
            // 사용자가 존재하는 경우
            if(entity == null || StringUtils.isEmpty(entity.getMemberNo())) return null;

            // 탈퇴한 사용자인 경우
            if(!"Y".equals(entity.getIsLogin())) return null;

            // 비밀번호 확인
            if(chkPw != null && chkPw.equals(entity.getPassword())){
                UserDTO user = new UserDTO(entity);
                return user;
            }
            
            // 사용자가 존재하지 않는 경우
            return null;

        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
            return null;
        }

    }
}
