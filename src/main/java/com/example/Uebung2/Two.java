package com.example.Uebung2;

import static com.example.Uebung2.Farbe.KREUZ;
import static com.example.Uebung2.Nummer.KOENIG;

public class Two {

    public static void main(String[] args) {
//        Farbe[] values = Farbe.values();
//        System.out.println(Arrays.toString(values));
//        System.out.println(Farbe.KREUZ.ordinal() + 1);
//        System.out.println(Farbe.values()[3]);

        Karte obj = new Karte(KREUZ, KOENIG);
        System.out.println(obj);
        Karte copy = new Karte(obj);
        System.out.println(copy);

       /* System.out.println(obj.farbe());
        System.out.println(obj.nummer());
        System.out.println(obj.toString());
        System.out.println(obj.equals(copy));
        System.out.println(obj == copy);
        System.out.println(obj.hashCode());*/
    }
}


