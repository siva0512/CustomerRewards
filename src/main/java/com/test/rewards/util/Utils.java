package com.test.rewards.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    private static SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyyhhmmss");

    public static boolean validDate(String date) {

        try {
            System.out.println("inside validating date for given date in 'MMddyyyyhhmmss'-" + date);
            formatter.parse(date);
            return true;
        } catch (ParseException e) {
            System.out.println("unable to parse the given date"+ e.getMessage());
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
            System.out.println("Three Months less date:"+ result);
            return result;
        } catch (ParseException e) {
            System.out.println("unable to parse the given date"+ e.getMessage());
            return "";
        }
    }
}
