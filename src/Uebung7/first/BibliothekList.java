package Uebung7.first;

import Uebung7.second.BuchNachTitel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringJoiner;

public class BibliothekList {
    private Collection<Buch> books;//most common interface, eg, List / Collection /...

    public BibliothekList() {
        this.books = new LinkedList<>();
    }

    public void einfügen(Buch b) {
        books.add(b);
        bestandSortierenNach(new BuchNachTitel());//..................????
    }

    public Collection<Buch> getBooks() {
        return books;
    }

    public Collection<Buch> sucheNachAutor(String autor) {
        Collection<Buch> temp = new LinkedList<>();
        for (Buch b : books) {
            if (b.getAutor().equalsIgnoreCase(autor)) {
                temp.add(b);
            }
        }
        return temp;
    }

    public Buch sucheNachISBN(String isbn){
        for (Buch b : books) {
            if(b.getIsbn().equals(isbn)){
                return b;
            }
        }
        return null;
    }


    public Collection<Buch> bestandSortierenNach(Comparator<Buch> comp){
        ArrayList<Buch> bookList = new ArrayList<>(books);//конструктор копирования, в новый список ArrayList / Set/.. старый
        bookList.sort(comp);
        return bookList;
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n", "[\n", "\n]");
        for (Buch book : books) {
            joiner.add(book.toString());
        }
        return joiner.toString();
    }

}

class Main {

    public static void main(String[] args) {
        BibliothekList bib = new BibliothekList();
        bib.einfügen(new Buch("Reinhard Schiedermeier", "Java Praktikum", "9784898645133", 23.0f));
        bib.einfügen(new Buch("Harvey Deitel", "How to program Java", "01303451517", 134.0f));
        bib.einfügen(new Buch("Bertrand Meyer", "Object Oriented Software Construction", "0136290310", 67.0f));
        bib.einfügen(new Buch("Bertrand Meyer", "Software Engineering Approaches for Offshore and Outsourced Development", "9783642018558", 78.0f));
        bib.einfügen(new Buch("Kathy Sierra", "Java von Kopf bis Fuss", "9783897214484", 110.0f));
        bib.einfügen(new Buch("Reinhard Schiedermeier", "Java Praktikum", "9784898645133", 23.0f));
        bib.einfügen(new Buch("Harvey Deitel", "How to program Java", "01303451517", 134.0f));
        bib.einfügen(new Buch("Bertrand Meyer", "Object Oriented Software Construction", "0136290310", 67.0f));
        bib.einfügen(new Buch("Bertrand Meyer", "Software Engineering Approaches for Offshore and Outsourced Development", "9783642018558", 78.0f));
        bib.einfügen(new Buch("Kathy Sierra", "Java von Kopf bis Fuss", "9783897214484", 110.0f));
        bib.einfügen(new Buch("Mark Utting", "Pratical Model based Testing", "9780123725011", 189.0f));

        System.out.println(bib);
        Collection<Buch> foundBooks = bib.sucheNachAutor("Bertrand Meyer");
        foundBooks.forEach(System.out::println);
    }
}

/*
class Test {
    public static void main(String[] args) {
        Collection<Map<String, Object>> books = new LinkedList<>();
        books.add(Map.of("autor", "Reinhard Schiedermeier","titel", "Java Praktikum", "isbn", "9784898645133", "price", 23.0f));
        books.add(Map.of("autor", "Reinhard Schiedermeier","titel", "Java Praktikum", "isbn", "9784898645133", "price", 23.0f));
        books.add(Map.of("autor", "Reinhard Schiedermeier","titel", "Java Praktikum", "isbn", "9784898645133", "price", 23.0f));
        books.add(Map.of("autor", "Reinhard Schiedermeier","titel", "Java Praktikum", "isbn", "9784898645133", "price", 23.0f));

        books.stream().filter(x -> ((Float) x.get("price")) < 100).forEach(x -> System.out.println(x));

    }
}*/
