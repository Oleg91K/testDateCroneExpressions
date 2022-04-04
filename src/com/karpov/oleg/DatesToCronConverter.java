package com.karpov.oleg;

import java.time.LocalDateTime;
import java.util.List;

public interface DatesToCronConverter {


    String convert(List<String> list) throws IllegalArgumentException, DatesToCronConvertException;


    default void getImplementationInfo() {
        System.out.println("ФИО: " + "Карпов Олег Алексеевич");
        System.out.println("Имя класса реализации: " + this.getClass().getSimpleName());
        System.out.println("Имя Пакета: " + this.getClass().getPackage().getName());
        System.out.println("Ссылка на github: " + "https://github.com/Oleg91K");
    }
}

