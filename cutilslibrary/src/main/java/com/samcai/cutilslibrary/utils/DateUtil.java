package com.samcai.cutilslibrary.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


/**
 * Created by caizhenliang on 2018/5/3.
 *
 * @version 1.0
 */
public class DateUtil {

	public static String parseDateToLocalTimezone(String time) {
        String inputPattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        String outputPattern = "HH:mm dd-MM-yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        inputFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        outputFormat.setTimeZone(TimeZone.getTimeZone("Pacific/Auckland"));
        String formattedDate = null;
        try {
            Date date = inputFormat.parse(time);
            formattedDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    public static String parseDateToUTCTimezone(String time) {
        String inputPattern = "HH:mm dd-MM-yyyy";
        String outputPattern = "yyyy-MM-dd HH:mm:ss'Z'";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        inputFormat.setTimeZone(TimeZone.getTimeZone("Pacific/Auckland"));
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        outputFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

        String formattedDate = null;
        try {
            Date date = inputFormat.parse(time);
            formattedDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }
}
