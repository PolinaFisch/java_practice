package com.example.chatgpt.logging.task03;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculatorService {
    public static void main(String[] args){
        log.debug("in main");

        try {
            add(2,6);
            subtract(4,7);
            multiply(7,9);
            divide(12,5);
            divide(12,0);
        }
        catch (Exception ex){
            log.error("Error in main func: {}", ex.getMessage());
        }
    }


    public static Integer add(int a, int b){
        log.trace("Entering method add()");
        log.debug("in add-func with {} + {}", a, b);

        int res = a + b;
        log.info("add-func is accompleshed with {}", res);
        return res;
    }

    public static Integer subtract(int a, int b){
        log.trace("Entering method subtract()");
        log.debug("in sub-func with {} - {}", a, b);

        int res = a-b;
        log.info("sub-func is accompleshed with {}", res);
        return res;

    }

    public static Integer multiply(int a, int b){
        log.trace("Entering method multiply()");
        log.debug("in mult-func with {} * {}", a, b);

        int res = a*b;
        log.info("mult-func is accompleshed with {}", res);
        return res;
    }


    public static Double divide(int a, int b) throws IllegalArgumentException {
        log.trace("Entering method divide()");
        log.debug("in div-func with {} / {}", a, b);

        if(b==0){
            log.error("Division by 0");
            throw new IllegalArgumentException("b is '0' ---> Exception");
        }
        Double res = (double) a/b;
        log.info("div-func is accompleshed with {}", res);
        return res;
    }
}
