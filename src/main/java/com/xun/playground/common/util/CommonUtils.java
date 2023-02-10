package com.xun.playground.common.util;

import com.xun.playground.common.config.dto.ConfigDTO;
import com.xun.playground.common.user.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtils {

    /**
     * session을 통해 user 값을 조회한다.
     * @param request
     * @return
     */
    public static UserDTO getUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute(ConfigDTO.SESSION_COOKIE_NAME);

        return user;
    }

    /**
     * 한국/서울의 localDateTime을 String 타입으로 반환한다.
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getKrDateTimeStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul")); // tilezone 설정
        String krTime = sdf.format(date);

        return sdf.format(krTime);
    }

    /**
     * 문자를 SHA256 + salt 를 사용해 암호화하고 반환한다.
     * @param word
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String encryption(String word) throws NoSuchAlgorithmException {
        // SHA1PRING 알고리즘 사용
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        // SALT 생성(무작위 랜덤 문자열)
        //String salt = new String(Base64.getEncoder().encode(bytes));

        // 문자+ salt 암호화
        MessageDigest md = MessageDigest.getInstance("SHA-256");
       // md.update(salt.getBytes());
        md.update(word.getBytes());
        String newWord = String.format("%064x", new BigInteger(1, md.digest()));

        return newWord;
    }
}
