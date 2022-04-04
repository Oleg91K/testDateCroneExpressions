package com.karpov.oleg;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DatesToCronConverter converter = new OurDatesToCronConverter();
        converter.getImplementationInfo();

        List<String> list1 = new ArrayList<>();
        list1.add("2022-01-25T08:00:00");
        list1.add("2022-01-25T08:30:00");
        list1.add("2022-01-25T09:00:00");
        list1.add("2022-01-25T09:30:00");
        list1.add("2022-01-26T08:00:00");
        list1.add("2022-01-26T08:30:00");
        list1.add("2022-01-26T09:00:00");
        list1.add("2022-01-26T10:30:00");

        List<String> list2 = new ArrayList<>();
        list2.add("2022-01-24T19:53:00");
        list2.add("2022-01-24T19:54:00");
        list2.add("2022-01-24T19:55:00");
        list2.add("2022-01-24T19:56:00");
        list2.add("2022-01-24T19:57:00");
        list2.add("2022-01-24T19:58:00");
        list2.add("2022-01-24T19:59:00");
        list2.add("2022-01-24T20:00:00");
        list2.add("2022-01-24T20:01:00");
        list2.add("2022-01-24T20:02:00");

        try {
            String cronString1 = converter.convert(list1);
            System.out.println(cronString1);

            String cronString2 = converter.convert(list2);
            System.out.println(cronString2);

        } catch (Exception ex) {
            System.out.println("Ошибка! " + ex.getMessage());
        }
    }

}
