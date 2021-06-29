package org.steve.palko.slps.web;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class StringToCalendarConverter implements Converter<String, Calendar> {

    @Override
    public Calendar convert(@NotNull String dateString) {
        var formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
