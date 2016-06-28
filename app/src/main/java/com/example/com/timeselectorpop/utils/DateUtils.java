package com.example.com.timeselectorpop.utils;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by SongYu on 2016/06/23.
 */
public class DateUtils {
    public static final Calendar calendar = Calendar.getInstance();
    public static final SimpleDateFormat dateFormat14 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
    public static final SimpleDateFormat dateFormat_detail6 = new SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINA);

    public static String formatDateString(String dateStr, SimpleDateFormat newFormat) {
        try {
            final Date parse = dateFormat14.parse(dateStr);
            final String format = newFormat.format(parse);
            if(format.contains("#")){
                String weekStr = getWeekStr(parse);
                return format.replace("#", weekStr);
            }
            return format;
        } catch (Exception e) {
            return "";
        }
    }
    public static String formatServerTime(@NonNull Date date) {
        return dateFormat14.format(date);
    }
    @NonNull
    private static String getWeekStr(Date date) {
        calendar.setTime(date);
        final int week = calendar.get(Calendar.DAY_OF_WEEK);
        String weekStr = "";
        switch (week) {
            case Calendar.SUNDAY:
                weekStr = "日";
                break;
            case Calendar.MONDAY:
                weekStr = "一";
                break;
            case Calendar.TUESDAY:
                weekStr = "二";
                break;
            case Calendar.WEDNESDAY:
                weekStr = "三";
                break;
            case Calendar.THURSDAY:
                weekStr = "四";
                break;
            case Calendar.FRIDAY:
                weekStr = "五";
                break;
            case Calendar.SATURDAY:
                weekStr = "六";
                break;
        }
        return weekStr;
    }
}
