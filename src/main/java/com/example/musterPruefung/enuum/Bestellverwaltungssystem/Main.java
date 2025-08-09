package com.example.musterPruefung.enuum.Bestellverwaltungssystem;

public class Main {
    public static void main(String[] args) {
        Bestellung cart = new Bestellung("name1");
        cart.produktHinzufügen(Product.KAFFEE);
        cart.produktHinzufügen(Product.KUCHEN);

        BestellArchiv.bestellungSpeichern(cart);

        Bestellung anothercart = new Bestellung("kunde2");
        anothercart.produktHinzufügen(Product.SANDWICH);
        anothercart.produktHinzufügen(Product.TEE);
        anothercart.produktHinzufügen(Product.KUCHEN);

        BestellArchiv.bestellungSpeichern(anothercart);

        System.out.println(BestellArchiv.ladeAlleBestellungen());
        System.out.println(BestellArchiv.berechneVerkäufeProProdukt());
        System.out.println(BestellArchiv.berechneGesamteinnahmen());

    }


}

