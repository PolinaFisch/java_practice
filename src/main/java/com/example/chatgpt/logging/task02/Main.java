package com.example.chatgpt.logging.task02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.trace("Application started.");
        log.debug("Application started.");
        log.info("Application started.");
        log.warn("Application started.");
        log.error("Application started.");

        method1(0);
    }

    public static void method1(Number n) {
        if(n.longValue() < 0){
            log.warn("< 0 ");
        }
        if (n.longValue() % 2 == 0) {
            log.info("Number {} is even", n);
        }
        if (n.longValue() % 2 != 0) {
            log.debug("Not even");
        }
        try {
            long res = 1 / n.longValue();
            System.out.println(res);
        } catch (ArithmeticException ex) {
            log.error("Division by zero.", ex);
        }
    }
}
