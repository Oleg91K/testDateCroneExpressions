package com.karpov.oleg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class OurDatesToCronConverter implements DatesToCronConverter {

    @Override
    public String convert(List<String> list) throws IllegalArgumentException, DatesToCronConvertException {
        if (list == null)
            return null;
        if (list.isEmpty())
            throw new DatesToCronConvertException();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        List<Integer> seconds = new ArrayList<>();
        List<Integer> minutes = new ArrayList<>();
        List<Integer> hours = new ArrayList<>();
        List<Integer> days = new ArrayList<>();
        List<Integer> months = new ArrayList<>();

        for (String s : list) {
            try {
                Date date = format.parse(s);
                saveInfo(date, seconds, minutes, hours, days, months);
            } catch (ParseException ex) {
                throw new IllegalArgumentException("Есть даты в неправильном формате!");
            }
        }

        String result = getExpression(seconds) + " " +
                getExpression(minutes) + " " +
                getExpression(hours) + " " +
                getExpression(days) + " " +
                getExpression(months) + " *";
        return result;
    }

    private void saveInfo(Date d, List<Integer> seconds, List<Integer> minutes, List<Integer> hours,
                          List<Integer> days, List<Integer> months) {

        if (!seconds.contains(d.getSeconds()))
            seconds.add(d.getSeconds());
        if (!minutes.contains(d.getMinutes()))
            minutes.add(d.getMinutes());
        if (!hours.contains(d.getHours()))
            hours.add(d.getHours());
        if (!days.contains(d.getDate()))
            days.add(d.getDate());
        if (!months.contains(d.getMonth() + 1))
            months.add(d.getMonth() + 1);
    }

    private String getExpression(List<Integer> differentValues) {
        if (differentValues.size() == 1)
            return differentValues.get(0).toString();
        if (differentValues.size() == 2)
            return differentValues.get(0).toString() + "/" + differentValues.get(1).toString();
        if (differentValues.size() < 5) {
            Collections.sort(differentValues);
            return differentValues.get(0).toString() + "-" + differentValues.get(differentValues.size() - 1).toString();
        } else {
            return "*";
        }
    }

}