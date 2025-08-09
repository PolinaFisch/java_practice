package com.example.Uebung7.second;

import com.example.Uebung7.first.BibliothekList;
import com.example.Uebung7.first.Buch;

public class BibliothekSet extends BibliothekList {

    @Override
    public void einfügen(Buch b) {
        if (!getBooks().contains(b)) {
            super.einfügen(b);
        }
    }
}

class Main {
    public static void main(String[] args) {
        BibliothekList bib = new BibliothekList();
        bib.einfügen(new Buch("Harvey Deitel", "How to program Java", "01303451517", 134.0f));
        bib.einfügen(new Buch("Harvey Deitel", "How to program Java", "01303451517", 134.0f));
        bib.einfügen(new Buch("Bertrand Meyer", "Object Oriented Software Construction", "0136290310", 67.0f));
        bib.einfügen(new Buch("Bertrand Meyer", "Object Oriented Software Construction", "0136290310", 67.0f));
        bib.einfügen(new Buch("Mark Utting", "Pratical Model based Testing", "9780123725011", 189.0f));
        bib.einfügen(new Buch("Bertrand Meyer", "Software Engineering Approaches for Offshore and Outsourced Development", "9783642018558", 78.0f));
        bib.einfügen(new Buch("Bertrand Meyer", "Software Engineering Approaches for Offshore and Outsourced Development", "9783642018558", 78.0f));
        bib.einfügen(new Buch("Kathy Sierra", "Java von Kopf bis Fuss", "9783897214484", 110.0f));
        bib.einfügen(new Buch("Kathy Sierra", "Java von Kopf bis Fuss", "9783897214484", 110.0f));
        bib.einfügen(new Buch("Reinhard Schiedermeier", "Java Praktikum", "9784898645133", 23.0f));
        bib.einfügen(new Buch("Reinhard Schiedermeier", "Java Praktikum", "9784898645133", 23.0f));
    }
}