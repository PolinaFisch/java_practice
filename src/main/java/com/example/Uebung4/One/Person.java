package com.example.Uebung4.One;

public abstract class Person {
    private final String vorname; // protected
    private final String nachname;
    private String strassenname;
    private String hausnummer;
    private String ort;
    private Integer postleitzahl;

    public Person(String vorname, String nachname) {
        validateNames(nachname, vorname);
        this.nachname = nachname;
        this.vorname = vorname;
    }

    private void validateNames(String nachname, String vorname) {
        if (nachname == null || vorname == null) {
            throw new IllegalArgumentException("Null value for name.");
        }
    }

    public Person(String vorname, String nachname, String strassenname, String hausnummer, String ort, Integer postleitzahl) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.strassenname = strassenname;
        this.hausnummer = hausnummer;
        this.ort = ort;
        this.postleitzahl = postleitzahl;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getStrassenname() {
        return strassenname;
    }

    public void setStrassenname(String strassenname) {
        this.strassenname = strassenname;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Integer getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(Integer postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    @Override
    public String toString() {
        return new StringBuilder()//
                .append("{")
                .append("vorname=")
                .append(vorname)
                .append(", nachname=")
                .append(nachname)
                .append(", strassenname=")
                .append(strassenname)
                .append(", hausnummer=")
                .append(hausnummer)
                .append(", ort=")
                .append(ort)
                .append(", postleitzahl=")
                .append(postleitzahl)
                .toString();
    }
}
