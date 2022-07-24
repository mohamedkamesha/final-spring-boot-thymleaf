package com.example.aabbcc.random;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomName {

    public static String generateRandomName(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                +"lmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString()+ LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString()+".pdf";
    }

}
