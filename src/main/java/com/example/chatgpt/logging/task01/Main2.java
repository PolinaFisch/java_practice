package com.example.chatgpt.logging.task01;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main2 {
    public static void main(String[] args) {
        log.info("application started");
        method1();
    }

    public static void method1() {
        log.info("in method1");
        try {
            method2();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    public static void method2() {
        if (Math.random() < 0.5) {
            throw new RuntimeException("Exception in method2");
        }
    }
}
