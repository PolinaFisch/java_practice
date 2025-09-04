package com.example.chatgpt.regex.task02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegexUtils {

    public static boolean isValidPassword(String input) {
        log.trace("Entering method");
        log.debug("Input String = {}", input);
        boolean isValid = false;
        if (input != null) {
            isValid = input.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$");
        }

        log.info("The string is " + (isValid ? "valid" : "invalid"));

        return isValid;
    }

    public static boolean isValidUsername(String input) {
        if (input == null) {
            return false;
        }
        return input.matches("^(?=.*[a-zA-Z])[a-zA-Z_]\\w{4,19}$");
    }
}
