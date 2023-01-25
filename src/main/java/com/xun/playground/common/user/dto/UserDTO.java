package com.xun.playground.common.user.dto;

import com.xun.playground.common.user.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 공통 User
 */
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private String memberNo;
    private String loginId;
    private String name;
    private String phone;
    private String email;

    // eneity값을 DTO에 set
    public UserDTO(UserEntity userEntity){
        this.memberNo = userEntity.getMemberNo();
        this.loginId = userEntity.getLoginId();
        this.name = userEntity.getName();
        this.phone = userEntity.getPhone();
        this.email = userEntity.getEmail();
    }
}
