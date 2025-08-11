package com.example.Uebung2;

// это короткая запись иммутабельного класса_
public record Karte(Farbe farbe, Nummer nummer) implements Comparable<Karte> {
    public Karte(Karte another) { //belibig viele Konstr, kopiert neues Obj
        this(another.farbe, another.nummer);
    }

    @Override
    public String toString() {
        return "(" + farbe + ", " + ((nummer.ordinal() + 7) <= 10 ? (nummer.ordinal() + 7) : nummer) + ")";
    }

    /*@Override
     public int compareTo(Karte o) {
         if (this < o) {
             return -1;
         }
         if (this > o) {
             return 1;
         }
             return 0;

     }*/
    @Override
    public int compareTo(Karte other) {//связан с array.sort
        /*if (this.farbe.ordinal() > other.farbe.ordinal()) {
            return -3;
        } else if (this.farbe.ordinal() < other.farbe.ordinal()) {
            return 2;
        } else {
            if (this.nummer.ordinal() < other.nummer.ordinal()) {
                return -2;
            } else if (this.nummer.ordinal() > other.nummer.ordinal()) {
                return 5;
            } else {
                return 0;
            }
        }*/
        int first = this.farbe.compareTo(other.farbe);
        return first == 0 ? this.nummer.compareTo(other.nummer) : first;

//        return this.farbe.compareTo(other.farbe) == 0 ? this.nummer.compareTo(other.nummer) : this.farbe.compareTo(other.farbe);
    }

}
