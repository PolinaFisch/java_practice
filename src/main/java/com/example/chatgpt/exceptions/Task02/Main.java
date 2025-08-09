package com.example.chatgpt.exceptions.Task02;

//Unchecked

public class Main {

    public static void main(String[] args) {
        String[] mas = {"42", "-5", "abc", "100"};

        for (String el : mas) {
            try {
                parsePositiveInt(el);
            } catch (BadInputException ex) {
                System.out.println(ex.getMessage());
            } finally {
                System.out.println("Обработка \"%s\" завершена.".formatted(el));
            }
        }


    }

    public static int parsePositiveInt(String s) throws BadInputException {//throws BadInputException можно опустить
        try {
            int newVar = Integer.parseInt(s);
            if (newVar <= 0) {
                throw new BadInputException("Недопустимый ввод: '" + s + "'");
            }
            return newVar;
        } catch (NumberFormatException ex) {
            throw new BadInputException("Недопустимый ввод: '" + s + "'", ex);
        }
    }

}
