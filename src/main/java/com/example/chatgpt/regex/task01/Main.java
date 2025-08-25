package com.example.chatgpt.regex.task01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str = "Some string with number 123 in he456re!";
        Pattern pattern = Pattern.compile("[a-zA-Z]+(\\d+)[a-zA-Z]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String g1 = matcher.group(1);
            System.out.println(g1);
        }
    }
}
