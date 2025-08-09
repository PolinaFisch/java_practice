package com.example.Uebung1.Three;

public class Zaehler {
    private long einer;
    private long zehner;

    public Zaehler(long zehner, long einer) {
        this.zehner = zehner;
        this.einer = einer;// поле einer тек объекта интит. параметром einer, кт пришел в конструктор
    }

    public void erhoeheUmEins() throws EinerUeberlauf {
        einer += 1;
        if (einer == 10) {
            throw new EinerUeberlauf();
        }
    }

    public void erhoeheUmZehn() throws Ueberlauf {
        zehner += 1;
        if (zehner == 10) {
            throw new Ueberlauf();
        }
    }


    public void zaehlen() {
        try {
            erhoeheUmEins();
        } catch (EinerUeberlauf ex1) {
            einer = 0;
            try {
                erhoeheUmZehn();
            } catch (Ueberlauf ex2) {
                System.out.println("Zähler größer 99");
                zehner = 0;
            }
        }
//        System.out.println(this);
//        System.out.printf("%s%n", this);
    }

    @Override
    public String toString() {
        return zehner + "" + einer;
    }

    public static void main(String[] args) {
        Zaehler obj = new Zaehler(9, 9);
        /*for (int i = 0; i <= 100; i++) { // fori + Tab
            obj.zaehlen();
            System.out.println(obj.toString());
        }*/
        obj.zaehlen();
        System.out.println(obj);
    }


}
