package com.example.chatgpt.exceptions.task01;

//Сhecked

public class Main {

    public static void main(String[] args) {
        int[] ageArray = {17, 18, 20};
        for (int age : ageArray) {
            try {
                checkAge(age);
            } catch (UnderageException ex) {
                System.err.println(ex.getMessage());
            } finally {
                System.out.println("Проверка завершена для возраста " + age);
            }
        }

    }

    public static void checkAge(int age) throws UnderageException {//throws UnderageException - обязателен
        if (age < 18) {
            throw new UnderageException("Возраст " + age + " слишком мал для совершеннолетия");
        }
    }

}

class UnderageException extends Exception {

    public UnderageException(String message) {
        super(message);
    }
}
