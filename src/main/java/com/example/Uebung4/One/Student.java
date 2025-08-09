package com.example.Uebung4.One;

public class Student extends Person{
    private Integer matrikelnummer;

    public Student(String vorname, String nachname){
        super(vorname, nachname);
    }

    public Student(String vorname, String nachname, String strassenname, String hausnummer, String ort, Integer postleitzahl, Integer matrikelnummer) {
        super(vorname, nachname, strassenname, hausnummer, ort, postleitzahl);
        this.matrikelnummer = matrikelnummer;
    }

    public Integer getMatrikelnummer() {
        return matrikelnummer;
    }

    public void setMatrikelnummer(Integer matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    @Override
    public String toString() {
        return "Student" + super.toString() + ", matrikelnummer=" + matrikelnummer + "}";
    }

    /*@Override
    public String toString() {//if Var is private, then via getter/setter
        return "Student{vorname=%s, nachname=%s, strassenname=%s, hausnummer=%s, ort=%s, postleitzahl=%d, matrikelnummer=%d}".formatted(getVorname(), getNachname(), getStrassenname(), getHausnummer(), getOrt(), getPostleitzahl(), matrikelnummer);
    }*/
}
