package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy_H-mm-ss-S");
        String formattedDate = sdf.format(date);
        System.out.println(formattedDate + "@mail.com");

        //2025-06-21-11-13
        }
    }
