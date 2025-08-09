package com.example.Uebung2;

import java.util.Arrays;

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

class Kartenspiel {
    private Karte[] coloumn;

    public Kartenspiel() {
        this.coloumn = new Karte [32];
        int count = 0;
        for (Farbe farbe : Farbe.values()) {
            for (Nummer nummer : Nummer.values()){
                Karte karte = new Karte(farbe, nummer);
                coloumn[count] = karte;
                count ++;
            }
        }
    }

    /**
     * Rearranges given element of the array and places it into the beginning
     *        *
     * [1, 2, 3, 4] -> [3, 1, 2, 4]
     *               *
     * [10, 5, 4, 0, 1] -> [1, 10, 5, 4, 0]
     *
     * @param index - index to rearrange
     * @param coloumn - source array
     */
    public void oneElReplace(int index, Karte[] coloumn){
        Karte[] masTemp = new Karte[coloumn.length];
        int count = 1;
        for(int i = 0; i < coloumn.length; i++){
            if(i != index){
                masTemp[count] = coloumn[i];
                count++;
            }
        }
        masTemp[0] = coloumn[index];
        System.arraycopy(masTemp,0,coloumn,0,coloumn.length);
    }

    public void mischen(){
//        Collections.shuffle(coloumn);
        int iterr = 50 + (int) (Math.random() * 51);
        for(int i = 0; i < iterr; i++){
            int nextIndex = (int) (Math.random() * 32);
            /*Karte temp = coloumn.remove(nextIndex);//loescht Variable und gibt es zuruck in temp
            coloumn.add(0, temp);*/
            oneElReplace(nextIndex,coloumn);
        }

    }

    public void kartenspielHinzufuegen(Kartenspiel secondKartenspiel){
        Karte[] mas = new Karte[this.coloumn.length + secondKartenspiel.coloumn.length];
        System.arraycopy(this.coloumn,0,mas,0,coloumn.length);
        System.arraycopy(secondKartenspiel.coloumn,0,mas,coloumn.length, secondKartenspiel.coloumn.length);
        this.coloumn = mas;
    }

    public void sort() {
        Arrays.sort(coloumn);
    }

    @Override
    public String toString() {
        return Arrays.toString(coloumn);
    }

}
