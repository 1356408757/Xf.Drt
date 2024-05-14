package com.trust.xfyl.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/
public class DateUtils {
    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";


    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    public static Date format(String date, String pattern) throws ParseException {
        if (date != null) {
            DateFormat df = new SimpleDateFormat(pattern);
            return df.parse(date);
        }
        return null;
    }

    /* public static String parseTime(String datdString) {
         datdString = datdString.replace("GMT", "").replaceAll("\\(.*\\)", "");
         //将字符串转化为date类型，格式2016-10-12
         SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z", Locale.CHINA);
         Date dateTrans = null;
         try {
             dateTrans = format.parse(datdString);
             return new SimpleDateFormat("yyyy-MM-dd").format(dateTrans).replace("-","/");
         } catch (ParseException e) {
             e.printStackTrace();
         }
         return datdString;

     }
 */

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public static Date timeStamp2Date1(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return null;
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return new Date(Long.valueOf(seconds + "000"));
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date_str 字符串日期
     * @param format   如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得当前时间戳（精确到秒）
     *
     * @return
     */
    public static String timeStamp() {
        long time = System.currentTimeMillis();
        String t = String.valueOf(time / 1000);
        return t;
    }



    /*public static void main(String[] args) {
        String dateStr1 = "2017-01-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);
        String dateStr3 = "2017-02-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr3);
        System.out.println(date2.before(date1));
        //相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        System.out.println(betweenDay);
    }*/

    /*  public static void main(String[] args) throws ParseException {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String ss = "年卡";
          String  time = "2018-08-22 14:44:40";
          Date time1 = DateUtilss.Time(ss, sdf.parse(time));
          System.out.println(sdf.format(time1));

      }*/
    public static String getBodyString(BufferedReader br) {
        String inputLine;
        String str = "";
        try {
            while ((inputLine = br.readLine()) != null) {
                str += inputLine;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return str;
    }

    /*public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("http://").append("192.168.1.116").append(":").append("10001").append("/").append("name");
        System.out.println(stringBuffer);
    }*/

    /*public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              String a= "2018-08-31 14:10:15";
              String b= "2018-08-31 14:5:00";
        Date parse = sdf.parse(a);
        Date parse1 = sdf.parse(b);
        String bettween = DateUtilss.bettweenSecondClock(parse, parse1);
        System.out.println(bettween);

    }*/

    /**
     * 计算俩个时间那之间的小时差
     */
    public static int bettween(Date endTime, Date startTime) {
        long from = startTime.getTime();
        long to = endTime.getTime();
        int hours = (int) ((from - to) / (1000 * 60 * 60));
        return hours;

    }

    /**
     * 计算俩个时间那之间的分钟差
     */
    public static int bettweenMinute(Date endTime, Date startTime) {
        long from = startTime.getTime();
        long to = endTime.getTime();
        int hours = (int) ((from - to) / (1000 * 60));
        return hours;

    }

    /**
     * 计算时间差（分钟）并输出为 分：秒
     *
     * @param endTime   结束时间
     * @param startTime 开始时间
     * @return
     */
    public static String bettweenSecondClock(Date endTime, Date startTime) {
        try {
            long to = startTime.getTime();
            long from = endTime.getTime();
            Long hours = (from - to) / (1000);
            String s = DateUtils.secondToTime(hours);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String secondToTime(long second) {
        /**
         * //转换分钟
         */
        long minutes = second / 60;
        /**
         *   //剩余秒数
         */
        second = second % 60;
        return minutes + "分" + second + "秒";

    }

}
