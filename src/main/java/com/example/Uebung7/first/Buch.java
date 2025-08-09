package com.example.Uebung7.first;

import java.util.Objects;

public class Buch {
    private String isbn;
    private String autor;
    private  String titel;
    private float preis;

    public Buch(String isbn, String autor, String titel, float preis) {
        this.isbn = isbn;
        this.autor = autor;
        this.titel = titel;
        this.preis = preis;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Buch buch)) return false;

        return Float.compare(preis, buch.preis) == 0 && isbn.equals(buch.isbn) && autor.equals(buch.autor) && titel.equals(buch.titel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preis, isbn, autor, titel);
    }

    @Override
    public String toString() {
        return String.format("%s \"%s\" %s %.1f", autor, titel, isbn, preis);
    }
}
