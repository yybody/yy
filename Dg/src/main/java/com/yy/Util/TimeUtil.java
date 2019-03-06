package com.yy.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 袁毅
 * @date 2018/12/26 0026-下午 2:27
 */
public class TimeUtil {


   //获取当前时间
    public static String getTime(){



        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(date);
        return format1;


    }


}
