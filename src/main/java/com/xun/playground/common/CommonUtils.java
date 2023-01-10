package com.xun.playground.common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CommonUtils {

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

}
