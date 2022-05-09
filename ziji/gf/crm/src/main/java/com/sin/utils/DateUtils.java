package com.sin.utils;


import org.apache.commons.lang3.time.DateFormatUtils;
import sun.rmi.runtime.Log;

import javax.xml.crypto.Data;
import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS =  "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd","yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm","yyyy-MM",
            "yyyy/MM/dd","yyyy/MM/dd HH:mm:ss","yyyy/MM/dd HH:mm","yyyy/MM",
            "yyyy.MM.dd","yyyy.MM.dd HH:mm:ss","yyyy.MM.dd HH:mm","yyyy.MM"
    };

    /**
     * 获取当前时间Date（）
     */
    public static Date getNoWDate(){
        return new Date();
    }

    public static String getDate(){
        return dataTimeNow(YYYY_MM_DD);
    }

    public static final  String getTime(){
        return dataTimeNow(YYYY_MM_DD_HH_MM_SS);

    }
    public static final String dataTimeNow(){
        return dataTimeNow(YYYYMMDDHHMMSS);
    }
    public static final String dataTimeNow(final String format){
        return parseDateToStr(format,new Date());

    }
    public static final String dataTime(final Date date){
        return parseDateToStr(YYYY_MM_DD,date);
    }
    public static final String parseDateToStr(final  String format,final Date date){
        return new SimpleDateFormat(format).format(date);

    }
    public static final Date dataTime(final String format,final String ts){
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 日期路径，年/月/日 2022/4/25
     */
    public static final String datePath(){
        Date now = new Date();
        return DateFormatUtils.format(now,"yyyy/MM/dd");
    }
    /**
     * 日期路径，20220425
     */
    public static final String dateTime(){
        Date now = new Date();
        return DateFormatUtils.format(now,"yyyyMMdd");
    }
    /**
     * 字符串转会为日期
     */
    public static Date parseDate(Object str){
        if(str == null){
            return null;
        }
        try {
            return parseDate(str.toString(),parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate(){
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }
    /**
     * 计算时间差
     */
    public static String getDatePoor(Date endDate,Date nowDate){
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        //获取两个时间的毫秒时间差
        long diff = endDate.getTime() - nowDate.getTime();
        //计算差多少天
        long day = diff / nd;
        //计算差多少小时
        Long hour = diff % nd / nh;
        //计算差多少分钟
        Long min = diff % nd % nh / nm;
        //计算差多少秒
        long sec = diff % nd % nh % nm /ns;
        return day + "天" + hour + "小时" + min + "分钟" ;
    }




}