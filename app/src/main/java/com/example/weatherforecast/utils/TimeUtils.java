package com.example.weatherforecast.utils;

import com.example.weatherforecast.models.Weather;

import java.util.Calendar;
import java.util.Date;


public class TimeUtils {

    public static boolean isDayTime(Weather W, Calendar Cal){
        Date Sunrise = W.getSunrise();
        Date Sunset = W.getSunset();
        boolean day;
        if((Sunrise != null) && (Sunset != null))
            day = Cal.after(W.getSunrise()) && Cal.before(W.getSunset());
        else{
            // fallback
            int hourOfDay = Cal.get(Calendar.HOUR_OF_DAY);
            day = (hourOfDay >= 7 && hourOfDay < 20);
        }
        return day;
    }
}
