package com.example.Uebung1.One;

// Иерархия исключений в Java
public class InvalidBirthdayException extends RuntimeException { //RuntimeException нельзя убирать - ошибка. Why?

    public InvalidBirthdayException(String dateStr) {
        super("Date " + dateStr + " is not a valid birthday."); //super всегда?
    }
}
