package com.htzw.study.utils;

/**
 * 实现按照年份、月份计算出相应的周，以及周的起止日期
 *
 * @author ZY
 * @version 1.0, 2017/7/27
 */

import java.text.SimpleDateFormat;
import java.util.*;

public class WeekUtils {

    /**
     * 获取当前时间所在年的周数
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取当前时间所在年的最大周数
     * @param year
     * @return
     */
    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        return getWeekOfYear(c.getTime());
    }

    /**
     * 获取某年的第几周的开始日期
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);
        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);
        return getFirstDayOfWeek(cal.getTime());
    }

    /**
     *  获取某年的第几周的结束日期
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);
        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);
        return getLastDayOfWeek(cal.getTime());
    }

    /**
     * 获取当前时间所在周的开始日期
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        // Monday
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        return c.getTime();
    }

    /**
     * 获取当前时间所在周的结束日期
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
        return c.getTime();
    }

    /**
     * 计算指定年月的周数
     * @param year
     * @param month
     * @return
     */
    public static int getWeekNumOfYearAndMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        return c.getActualMaximum(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 计算指定年月的周数
     * @param year
     * @param month
     * @return
     */
    public static int getDayNumOfYearAndMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定日期的前一天
     * @param specifiedDay
     * @return
     */
    public static Date getSpecifiedDayBefore(Date specifiedDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(specifiedDay);
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day - 1);
        return calendar.getTime();
    }

    /**
     * 计算指定日期在全年的第几周
     * @param day
     * @return
     */
    public static int getYearWeekOfDay(String day){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(day);
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            calendar.setTime(date);
            return calendar.get(Calendar.WEEK_OF_YEAR);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 根据年月获取当月最后一天
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    /**
     * 根据年月获取数据每月的周和对应日期列表
     * @param year
     * @param month
     * @return
     */
    public static List<String> getWeekDayListString(int year, int month) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINA);
        // 定义输入列表
        List<String> result = new ArrayList<>();
        int add = 0;
        try {
            // 比较第一周是否包含1月1日，如果不包含，add为1
            Date yearWeekFirstDay = df.parse(df.format(getFirstDayOfWeek(year, 1)));
            String yearFistDayString = year + "/" + "01" + "/" + "01";
            Date yearFirstDay = df.parse(yearFistDayString);
            // 第一周的第一天在1月1日以后,要增加一个周数
            if (yearFirstDay.before(yearWeekFirstDay)) {
                add = 1;
            }
            // 获取数据
            if (month == 1) {
                if (add == 1) {
                    //获取第一周最后一天，通过第二周第一天减一天
                    Date firstWeeklastDayDate = getFirstDayOfWeek(year, 1);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(firstWeeklastDayDate);
                    cal.add(Calendar.DATE, -1);
                    String str = "第" + getIntactWeek(add) + "周" + " " + "0" + month + "月" + "01" + "日" + "~" + sdf.format(cal.getTime());
                    result.add(str);
                }
                for (int i = 1; i < 7; i++) {
                    String str = "第" + getIntactWeek(add + i) + "周" + " " + sdf.format(getFirstDayOfWeek(year, i)) + "~" + sdf.format(getLastDayOfWeek(year, i));
                    result.add(str);
                    Date weekLastDay = df.parse(df.format(getLastDayOfWeek(year, i)));
                    String monthFistDayString = year + "/" + "0" + (month + 1) + "/" + "01";
                    Date monthFirstDay = df.parse(monthFistDayString);
                    // 如果第N周的最后一天已经是超过或者等于下一月的第一天就结束
                    if (monthFirstDay.after(weekLastDay)) {
                        continue;
                    } else {
                        return result;
                    }
                }
            } else if (month == 12) {
                // 获取当前月份第一天在全年的第几周
                int realityWeek = getYearWeekOfDay(year + "-" + month + "-" + "01");
                int inquiryWeek = realityWeek + add;
                for (int i = 0; i < 6; i++) {
                    Date weekLastDay = df.parse(df.format(getLastDayOfWeek(year, realityWeek + i)));
                    String monthLastDayString = year + "/" + month + "/" + getDayNumOfYearAndMonth(year, month);
                    Date monthLastDay = df.parse(monthLastDayString);
                    // 如果第N周的最后一天已经是超过本月的最一天就结束
                    if (monthLastDay.after(weekLastDay)) {
                        String str = "第" + getIntactWeek(inquiryWeek + i) + "周" + " " + sdf.format(getFirstDayOfWeek(year, realityWeek + i)) + "~" + sdf.format(getLastDayOfWeek(year, realityWeek + i));
                        result.add(str);
                        continue;
                    } else {
                        // 如果最后一周的第一天已经是不超过本月的最一天就结束
                        Date weekFirstDay = df.parse(df.format(getFirstDayOfWeek(year, realityWeek + i)));
                        if (monthLastDay.before(weekFirstDay)) {
                            continue;
                        } else {
                            String str = "第" + getIntactWeek(inquiryWeek + i) + "周" + " " + sdf.format(getFirstDayOfWeek(year, realityWeek + i)) + "~" + sdf.format(monthLastDay);
                            result.add(str);
                        }
                        return result;
                    }
                }
            } else {
                // 获取当前月份第一天在全年的第几周
                int realityWeek = getYearWeekOfDay(year + "-" + month + "-" + "01");
                int inquiryWeek = realityWeek + add;

                String nowMonthLastDayString = year + "/" + month + "/" + "01";
                Date nowmonthFirstDay = df.parse(nowMonthLastDayString);
                Date nowWeekFirstDay = df.parse(df.format(getFirstDayOfWeek(year, realityWeek - 1)));
                if (!nowWeekFirstDay.before(nowmonthFirstDay) && !nowWeekFirstDay.after(nowmonthFirstDay)) {
                    String str = "第" + getIntactWeek(realityWeek) + "周" + " " + sdf.format(getFirstDayOfWeek(year, realityWeek - 1)) + "~" + sdf.format(getLastDayOfWeek(year, realityWeek - 1));
                    result.add(str);
                }
                for (int i = 0; i < 6; i++) {
                    Date weekLastDay = df.parse(df.format(getLastDayOfWeek(year, realityWeek + i)));
                    String monthFistDayString;
                    if (month > 9) {
                        monthFistDayString = year + "/" + (month + 1) + "/" + "01";
                    } else {
                        monthFistDayString = year + "/" + "0" + (month + 1) + "/" + "01";
                    }
                    Date monthFirstDay = df.parse(monthFistDayString);
                    // 如果第N周的最后一天已经是超过或者等于下一月的第一天就结束
                    if (monthFirstDay.after(weekLastDay)) {
                        String str = "第" + getIntactWeek(inquiryWeek + i) + "周" + " " + sdf.format(getFirstDayOfWeek(year, realityWeek + i)) + "~" + sdf.format(getLastDayOfWeek(year, realityWeek + i));
                        result.add(str);
                        continue;
                    } else {
                        String monthLastDayString = year + "/" + month + "/" + getDayNumOfYearAndMonth(year, month);
                        Date monthLastDay = df.parse(monthLastDayString);
                        Date weekFirstDay = df.parse(df.format(getFirstDayOfWeek(year, realityWeek + i)));
                        if (monthLastDay.before(weekFirstDay)) {
                            continue;
                        } else {
                            String str = "第" + getIntactWeek(inquiryWeek + i) + "周" + " " + sdf.format(getFirstDayOfWeek(year, realityWeek + i)) + "~" + sdf.format(getLastDayOfWeek(year, realityWeek + i));
                            result.add(str);
                        }
                        return result;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将0-9变为00-09
     * @param week
     * @return
     */
    private static String getIntactWeek(int week) {
        if (week < 10) {
            return "0" + String.valueOf(week);
        } else {
            return String.valueOf(week);
        }
    }
}
