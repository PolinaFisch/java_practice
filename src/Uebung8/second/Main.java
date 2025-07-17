package Uebung8.second;

import java.util.ArrayList;
import java.util.List;

public class Main {

}

class Buch {

    protected final String isbn, autor, titel;
    private float price;

    public Buch(String isbn, String autor, String titel, float price) {
        super();
        this.isbn = isbn;
        this.autor = autor;
        this.titel = titel;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // .. übrigen getter weggelassen

    public String toString() {
        return "\n" + String.format("%-22s", autor) + " "
                + String.format("\"%-15s\"", titel) + " "
                + String.format("%13s", isbn) + " "
                + String.format("%.1f", price);
    }
}

class BuchTest {

    public static void main(String[] args) {
        List<Buch> books = new ArrayList<>();
        books.add(new Buch("Reinhard Schiedermeier", "Java Praktikum ", "9784898645133", 44.0f));
        books.add(new Buch("Harvey Deitel", "How to program Java", "  01303451517", 120.0f));
        books.add(new Buch("Kathy Sierra", "Software Engineering Basics", "9783897214484", 97.0f));
        books.add(new Buch("Bertrand Meyer", "Object Oriented Software Construction", "   0136290310", 66.0f));
        books.add(new Buch("Bertrand Meyer", "Software Engineering Approaches for Offshore and Outsourced Development", "9783897214484", 99.0f));
        books.add(new Buch("Kathy Sierra", "Java von Kopf bis Fuss", "9783642018558", 75.0f));

        //books.stream().peek / map/ count / filter - for further action
        books.stream().peek(buch -> buch.setPrice(buch.getPrice() + 10)).forEach(x -> System.out.println(x));
    }

}

