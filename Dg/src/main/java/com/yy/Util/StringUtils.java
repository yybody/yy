package com.yy.Util;

/**
 * @author 袁毅
 * @date 2018/11/20 0020-上午 11:29
 */
public class StringUtils {
    // 字符串的一些工具类方法

    /**
     * 获取文件的名字。比如"D:/picture/meizi.jpg"获取到的就是"meizi.jpg"
     *
     * @param str
     *            文件地址
     * @return
     */
    public static String getFileName(String str) {
        //获取"/"字符最后一次出现的位置
        int beginIndex = str.lastIndexOf("/") + 1;
        int endIndex = str.length();
        //截取字符串
        String location2 = str.substring(beginIndex, endIndex);
        return location2;
    }
}
