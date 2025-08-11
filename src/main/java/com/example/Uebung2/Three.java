package com.example.Uebung2;

public class Three {
    public static void main(String[] args) {
        Kartenspiel kartenspiel = new Kartenspiel();
        Kartenspiel kartenspiel1 = new Kartenspiel();

        System.out.println(kartenspiel);
        kartenspiel.mischen();
        System.out.println(kartenspiel);

        kartenspiel.kartenspielHinzufuegen(kartenspiel1);
        System.out.println(kartenspiel);

        kartenspiel.sort();
        System.out.println(kartenspiel);
    }


}

