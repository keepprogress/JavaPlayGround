package com.nick.playground.mainmethods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class logDate {
    public static void main(String[] args) {
        Date processDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        String output = simpleDateFormat.format(processDate);
        System.out.println(processDate);
        System.out.println(output);
    }
}
