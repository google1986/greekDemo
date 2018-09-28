package com.htzw.study.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
* @Description:    提供时间相关操作，如获取当前时间字符串、时间类型的转换等<br>
* @Author:         glj
* @CreateDate:     2018/9/28 16:29
* @Version:        1.0
*/
public class TimeUtils {

    /**
     * getTime : 获取当前时间字符串
     *
     * @param format : 格式
     * @return 当前时间转换成的字符串
     */
    public static String getTime(String format) {
        return calendarToString(Calendar.getInstance(), format);
    }


    /**
     * 将当前时间转换为yyyyMMdd格式的字符串
     *
     * @return 当前时间转换成的yyyyMMdd格式的字符串
     */
    public static String dayToString() {
        return dayToString(Calendar.getInstance());
    }

    /**
     * timeToString : 将当前时间转换为yyyy-MM-ddTHH:MM:ss.SSS格式的字符串
     *
     * @return : 当前时间的yyyy-MM-ddTHH:mm:ss.SSS格式的字符串
     */
    public static String timeToString() {
        String timestr = calendarToString(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss.SSS");
        return timestr.replace(" ", "T");
    }

    /**
     * 根据时间戳获取年份
     * ZY
     *
     * @param time 时间戳
     * @return 年份
     */
    public static String getYearByLongTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Long lTime = Long.parseLong(time);
        String year = format.format(lTime);
        return year;
    }

    /**
     * 根据时间戳获取月份
     * ZY
     *
     * @param time 时间戳
     * @return 月份
     */
    public static String getMonthByLongTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat("MM");
        Long lTime = Long.parseLong(time);
        String month = format.format(lTime);
        return month;
    }

    /**
     * 根据时间戳获取指定格式时间
     * ZY
     *
     * @param time 时间戳
     * @return 月份
     */
    public static String getTimeByLongTime(String time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long lTime = Long.parseLong(time);
        String newTime = formatter.format(lTime);
        return newTime;
    }

    /**
     * 将Calendar类型转换为yyyyMMdd格式的字符串
     *
     * @param calendar
     * @return
     */
    public static String dayToString(Calendar calendar) {
        if (calendar == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String result = formatter.format(calendar.getTime());
        return result;
    }

    /**
     * 转换时间日期格式字串为long型
     *
     * @param time 格式为：yyyy-MM-dd HH:mm:ss的时间日期类型
     */
    public static Long convertTimeToLong(String time) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sdf.parse(time);
            return date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /**
     * 根据当前日期获取本月的第一天
     * @return 时间格式为：XXXX-XX-XX
     */
    public static String getFirstDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前日期
        Calendar cal_1 = Calendar.getInstance();
        cal_1.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        cal_1.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(cal_1.getTime());
    }

    /**
     * 根据当前日期获取本月的最后一天
     * @return 时间格式为：XXXX-XX-XX
     */
    public static String getLastDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format.format(cale.getTime());
    }

    /**
     * 将Calendar类型转换为指定格式的字符串
     *
     * @param calendar
     * @return
     */
    public static String timeToString(Calendar calendar, String format) {
        if (calendar == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String result = formatter.format(calendar.getTime());
        return result;
    }

    /**
     * 将Calendar类型转换为format格式的字符串，若格式错误，转换为yyyy-MM-ddTHH:mm:ss格式
     *
     * @param calendar：Calendar对象
     * @param format：格式
     * @return：符合format格式的字符串
     */
    public static String calendarToString(Calendar calendar, String format) {
        if (calendar == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.format(calendar.getTime());
        } catch (Exception e) {
            return calendarToString(calendar, format);
        }
    }

    /**
     * 将Calendar类型转换为yyyy-MM-dd HH:mm:ss格式的字符串
     *
     * @param calendar
     * @return
     */
    public static String calendarToString(Calendar calendar) {
        if (calendar == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = formatter.format(calendar.getTime());
        // 将日期格式变成"yyyy-MM-ddTHH:mm:ss"
        result = result.replace(" ", "T");
        return result;
    }

    /**
     * 将yyyy-MM-ddTHH:mm:ss.UUU格式的字符串转换为Calendar类型
     *
     * @param calendarString：yyyy-MM-ddTHH:mm:ss.UUU的字符串
     * @return：转换生成的Calendar对象
     */
    public static Calendar stringToCalendar(String calendarString) {
        if (calendarString == null || calendarString.trim().length() == 0) {
            return null;
        }
        String dateStr = calendarString;
        if (calendarString.trim().indexOf("T") != -1) {
            dateStr = calendarString.trim().replace("T", " ");
        }
        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        if (dateStr.indexOf(".") != -1) {
            dateFormat += ".SSS";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(formatter.parse(dateStr));
        } catch (ParseException e) {
            return null;
        }
        return calendar;
    }

    /**
     * 将字符串转换为Calendar类型
     *
     * @param calendarString：yyyy-MM-ddTHH:mm:ss.UUU的字符串
     * @param format：生成Calendar对象的format
     * @return：转换生成的Calendar对象
     */
    public static Calendar stringToCalendar(String calendarString, String format) {
        if (calendarString == null || calendarString.trim().length() == 0) {
            return null;
        }
        String dateStr = calendarString;
        if (calendarString.trim().indexOf("T") != -1) {
            dateStr = calendarString.trim().replace("T", " ");
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();

        try {

            calendar.setTime(formatter.parse(dateStr));
        } catch (ParseException e) {
            return null;
        }
        return calendar;
    }

    /**
     * 检查日期格式是否正确
     *
     * @param time：被检查的日期字符串
     * @param dateFormat：要求的日期format
     * @return：时期格式是否正确
     */
    public static boolean checkDayFormat(String time, String dateFormat) {
        if (time == null) {
            return false;
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            try {
                formatter.parse(time);
                return true;
            } catch (ParseException e) {
                return false;
            }
        }
    }

    /**
     * 将字符串转换为Date类型
     *
     * @param dateString：yyyy-MM-ddTHH:mm:ss.UUU的字符串
     * @param format：生成Date对象的format
     * @return：转换生成的Date对象
     */
    public static Date stringToDate(String dateString, String format) {
        if (dateString == null || dateString.trim().length() == 0) {
            return null;
        }
        String dateStr = dateString;
        if (dateString.trim().indexOf("T") != -1) {
            dateStr = dateString.trim().replace("T", " ");
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        Date date;
        try {

            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    public static Date stringToDate(String dateString) {
        if (dateString == null || dateString.trim().length() == 0) {
            return null;
        }
        String dateStr = dateString;
        if (dateString.trim().indexOf("T") != -1) {
            dateStr = dateString.trim().replace("T", " ");
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date;
        try {

            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    /**
     * 将Date类型转换为yyyy-MM-ddTHH:mm:ss格式的字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = formatter.format(date.getTime());
        // 将日期格式变成"yyyy-MM-ddTHH:mm:ss"
        //result = result.replace(" ", "T");
        return result;
    }

    /**
     * 将Date类型转换为指定格式的字符串
     *
     * @param date   当前时间
     * @param format 时间格式
     * @return
     */
    public static String dateToString(Date date, String format) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String result = formatter.format(date.getTime());
        return result;
    }

    /**
     * 将Date类型转换为yyyy-MM-dd格式的字符串
     *
     * @param date
     * @return
     */
    public static String dateToShortString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String result = formatter.format(date.getTime());
        return result;
    }

    public static String getYear(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String result = formatter.format(date.getTime());
        return result;
    }

    public static String getMonth(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        String result = formatter.format(date.getTime());
        return result;
    }

    public static String longToString(Long time) {
        if (time == null || time == 0) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = formatter.format(time);
        return str;
    }

    public static Long stringToLong(String time) {
        if (time == null || time.isEmpty()) {
            return 0L;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date str = new Date();
        try {
            str = formatter.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Long.valueOf(str.getTime());
    }

    public static String stringToDateString(String time) {
        if (time == null && time.isEmpty()) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = formatter.format(time);
        return str;
    }

    @SuppressWarnings("unchecked")
    public static String getYearFromBelongDate(List belongDates) {
        if (belongDates == null & belongDates.size() == 0) {
            return null;
        }
        List<String> result = new ArrayList<>();

        for (Object object : belongDates) {
            String[] str = ((String) object).split("-");
            result.add(str[0]);
        }

        return result.toString().substring(1, result.toString().length() - 1);
    }

    @SuppressWarnings("unchecked")
    public static String getMonthFromBelongDate(List belongDates) {
        if (belongDates == null & belongDates.isEmpty()) {
            return null;
        }
        List<String> result = new ArrayList<>();

        for (Object object : belongDates) {
            String[] str = ((String) object).split("-");
            result.add(str[1]);
        }

        return result.toString().substring(1, result.toString().length() - 1);
    }

    /**
     * 格式化时间，将时间转换为yyyy-MM-dd HH:mm格式，便于后期使用
     *
     * @param str 时间信息
     * @return 格式化后的时间
     */
    public static String formatingTime(String str) {
        Date date = stringToDate(str, "yyyy-MM-dd HH:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return formatter.format(date);
    }

    /**
     * 将时间格式为年月日转换为yyyy-MM-dd格式
     *
     * @param str 时间信息
     * @return 转换后的时间
     */
    public static String yearToTime(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = stringToDate(str, "yyyy年MM月dd日");
        return formatter.format(date);
    }

}