package com.xun.playground.member.account.service;

import com.xun.playground.common.CommonUtils;
import com.xun.playground.common.user.dto.UserDTO;
import com.xun.playground.common.user.entity.UserEntity;
import com.xun.playground.common.user.repository.UserRepository;
import com.xun.playground.member.account.repository.AccountRepository;
import com.xun.playground.member.dto.MemberDTO;
import com.xun.playground.member.entity.MemberEntity;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * 회원계정 Service
 */
@Transactional
@Service
public class AccountService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    /**
     * 회원정보 조회
     * @param memberNo
     * @return
     */
    public MemberDTO findUser(String memberNo){
        MemberDTO member = new MemberDTO();

        if(StringUtils.isEmpty(memberNo)) return member;

        Optional<MemberEntity> entity = accountRepository.findById(memberNo);
        if(!entity.isPresent()) return member;

        member = new MemberDTO(entity.get());
        return member;
    }


    /**
     * 입력한 인증정보가 일치하는지 확인
     * @param memberNo
     * @param password
     * @return
     */
    public boolean checkAuthUser(String memberNo, String password) {
        boolean result = false;
        if(StringUtils.isEmpty(memberNo) || StringUtils.isEmpty(password)) return result;

        try{
            String newPw = CommonUtils.encryption(password);
            Optional<MemberEntity> entity = accountRepository.findById(memberNo);

            if(!entity.isPresent()) return result; // 사용자 존재하지 않는 경우

            // 비밀번호 일치하는 경우
            if(newPw != null && newPw.equals(entity.get().getPassword())) result = true;

        } catch (NoSuchAlgorithmException e){
            logger.error(e.getMessage());
        }

        return result;
    }


    /**
     * 회원정보 수정
     * @param memberNo
     * @param memberDto
     * @return
     */
    public boolean modifyAccount(String memberNo, MemberDTO memberDto){
        boolean result = false;

        if(StringUtils.isEmpty(memberNo) || memberDto == null) return result;

        Optional<MemberEntity> entity = accountRepository.findById(memberNo);

        if(entity.isPresent()) {
            entity.get().update(memberDto.getName(), memberDto.getPhone()
                    ,memberDto.getEmail(), memberDto.getAddress(), memberDto.getHobby(), memberNo);

            result = true;
        }

        return result;

    }

    /**
     * 회원 탈퇴
     * @param memberNo
     * @return
     */
    public boolean leaveAccount(String memberNo){
        boolean result = false;

        if(StringUtils.isEmpty(memberNo)) return result;

        int isUpdate = accountRepository.leaveAccount(memberNo);
        // 업데이트 된 항목 존재하는 경우
        if(isUpdate > 0) result = true;

        return result;
    }

}
