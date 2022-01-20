package com.test.rewards.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    private static final Logger LOGGER = LogManager.getLogger(Utils.class.getName());

    private static SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyyhhmmss");
//    private static SimpleDateFormat formatter2 = new SimpleDateFormat("MMddyyyyhhmmss");

    public static String getCurrentTimeStamp() {

        LOGGER.debug("inside get current timestamp in 'MMddyyyyhhmmss' format");
        return formatter.format(new Date());
    }

    public static String getFormattedDate(Date date) {

        LOGGER.debug("inside get formatted date for given date in 'MMddyyyyhhmmss'-" + date);
        return formatter.format(date);
    }

    public static boolean validDate(String date) {

        try {
            LOGGER.info("inside validating date for given date in 'MMddyyyyhhmmss'-" + date);
            formatter.parse(date);
            return true;
        } catch (ParseException e) {
            LOGGER.error("unable to parse the given date", e.getMessage());
            return false;
        }
    }

    public static String lessThreeMonths(String date) {

        try {

            Date myDate = formatter.parse(date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(myDate);
            calendar.add(Calendar.DAY_OF_YEAR, -90);

            Date previousDate = calendar.getTime();
            String result = formatter.format(previousDate);
            LOGGER.info("Three Months less date:"+ result);
            return result;
        } catch (ParseException e) {
            LOGGER.error("unable to parse the given date", e.getMessage());
            return "";
        }
    }

    public static Date getDateFromString(String str) throws ParseException {

        LOGGER.debug("inside getDateFromString for given string in 'MMddyyyyhhmmss'-" + str);
        return formatter.parse(str);
    }

    public static int getMonth(String str) throws ParseException {

        LOGGER.debug("inside getMonth for given string in 'MMddyyyyhhmmss'-" + str);
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatter.parse(str));
        return cal.get(Calendar.MONTH);
    }

    public static String getMonthName(String str) throws ParseException {

        LOGGER.debug("inside getMonthName for given string in 'MMddyyyyhhmmss'-" + str);
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatter.parse(str));
        return new SimpleDateFormat("MMM").format(cal.getTime());
    }

    public static boolean verifyCurrentYear(String date) {
        try {
            LOGGER.debug("inside verifyCurrentYear for given string in 'MMddyyyyhhmmss'-" + date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(formatter.parse(date));
            Calendar cal1 = Calendar.getInstance();
            return cal1.get(Calendar.YEAR) == cal.get(Calendar.YEAR) ? true : false;
        } catch (ParseException e) {
            LOGGER.error("error occurred while parsing date-" + e.getMessage());
            return false;
        }
    }
}
