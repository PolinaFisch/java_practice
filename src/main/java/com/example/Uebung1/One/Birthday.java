package com.example.Uebung1.One;

import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Birthday {

    //Константа FORMAT: новый объект класса Даты
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    private String Geburtstagsdatum;

    public Birthday(String Geburtstagsdatum) {
        checkday(Geburtstagsdatum);
        this.Geburtstagsdatum = Geburtstagsdatum;
    }

    public String getGeburtstagsdatum(){
        return Geburtstagsdatum;
    }

    static void checkday(String dateStr) {
        try {
            FORMAT.parse(dateStr); //чем служит FORMAT?
        } catch (ParseException e) { //ParseException unused
            throw new InvalidBirthdayException(dateStr);
        }
    }

}
