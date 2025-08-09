package com.example.Uebung8.sixth;

import com.example.Uebung7.first.Buch;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Main {
    public static void main(String[] args) {
        Optional<String> res = Stream.of("str1", "str2", "str3", "str10")
                .filter(x -> x.length() > 5)
                .findFirst();
        if (res.isPresent()) {//
            String value = res.get();
            String[] split = value.split("r");
            System.out.println(split[0]);
            System.out.println(split[1]);
        }

        Stream.of("str1", "str2", "str3", "str10")
                .filter(x -> x.length() > 5)
                .forEach(x1 -> {
                    System.out.println(x1);
                });
    }
}

class AbstractBibliothek {

    protected Collection<Buch> buecher = new ArrayList<>();

    public boolean einfuegen(Buch b) {
        if (b != null)
            return buecher.add(b);
        else
            return false;
    }

    public Collection<Buch> getBuecher() {
        return buecher;
    }

    public Collection<Buch> sucheNachAutor(String autor) {
        return buecher.stream()
                .filter(b -> b.getAutor().equals(autor))
                .toList();
    }

    public Buch sucheNachISBN(String isbn) {
        return buecher.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public Map<String, List<Buch>> bestandNachAutorAuflisten() {
        return buecher.stream().collect(Collectors.groupingBy(b -> b.getAutor()));
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(",\n", "[\n", "]");
        for (Buch book : buecher) {
            joiner.add(book.toString());
        }
        return joiner.toString();
    }

}

class BibliothekTest extends AbstractBibliothek {

    public static void main(String[] args) {
        AbstractBibliothek bib = init();
        System.out.println("Bibliothek Liste:" + bib);

        System.out.println("Suche nach ISBN (gültig)\n"
                + bib.sucheNachISBN("9783897214484"));
    }

    public static AbstractBibliothek init() {

        String[][] bestand = {
                {"9784898645133", "Reinhard Schiedermeier", "Java Praktikum", "34"},
                {"01303451517", "Harvey Deitel", "How to program Java", "110"},
                {"9783897211284", "Kathy Sierra", "Software Engineering Basics", "87"},
                {"0136290310", "Bertrand Meyer", "Object Oriented Software Construction", "56"},
                {"9783897214484", "Bertrand Meyer", "Software Engineering Approaches for Offshore and Outsourced Development", "89"},
                {"9783642018558", "Kathy Sierra", "Java von Kopf bis Fuss", "65"}
        };
        AbstractBibliothek bibliothek = new BibliothekTest();
        for (String[] line : bestand) {
            bibliothek.einfuegen(new Buch(line[0], line[1], line[2], Float.parseFloat(line[3])));
        }

        return bibliothek;
    }
}