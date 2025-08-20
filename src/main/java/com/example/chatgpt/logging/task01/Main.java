package com.example.chatgpt.logging.task01;

import java.util.logging.Logger;

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        logger.info("application started");
        method1();
    }

    public static void method1() {
        logger.info("in method1");
        try {
            method2();
        } catch (Exception ex) {
            logger.severe(ex.getMessage());
        }
    }

    public static void method2() {
        if (Math.random() < 0.5) {
            throw new RuntimeException("Exception in method2");
        }
    }
}
