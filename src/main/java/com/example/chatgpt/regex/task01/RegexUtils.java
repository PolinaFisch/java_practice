package com.example.chatgpt.regex.task01;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class RegexUtils {

    public static boolean isValidEmail(String email) {
        log.debug("Checking email: {}", email);
        if (email == null) {
            log.info("Invalid email.");
            return false;
        }

        boolean isValid = email.matches("^[^@]+@[^@]+\\.\\w{2,3}$");
        if (isValid) {
            log.info("Valid email.");
        } else {
            log.info("Invalid email.");
        }
        return isValid;
    }

    public static List<Integer> extractIntegers(String input) {
        log.trace("Checking input: {}", input);
        if (input == null) {
            return Collections.emptyList();
        }
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(input);
        List<Integer> res = new ArrayList<>();
        while (matcher.find()) {
            String match = matcher.group();
            log.debug("Found match: {}", match);
            try {
                int number = Integer.parseInt(match);
                res.add(number);
            } catch (NumberFormatException ex) {
                log.warn("Number {} is too large for an integer.", match);
            }

        }
        log.info("Final list: {}", res);
        return Collections.unmodifiableList(res);
    }

    public static String replaceSpaces(String input) {
        log.trace("Entering method");
        log.debug("Checking input {}", input);

        if(input == null){
            return null;
        }

        String res = input.replaceAll("\\s+", "_");
        log.info("Resulting string: {}", res);

        return res;
    }

    public static boolean isValidPhoneNumber(String input){
        log.trace("Entering method: 'isValidPhoneNumber' ");
        log.debug("Checking input: {}", input);

        if(input == null){
            log.warn("Input is empty");
            return false;
        }

        boolean isValid = input.matches("^\\+\\d{11,15}$");
        if (isValid) {
            log.info("Valid phone number");
        } else {
            log.info("Phone number is NOT valid");
        }
        return isValid;
    }

}
