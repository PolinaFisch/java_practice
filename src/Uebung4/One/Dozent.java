package Uebung4.One;

import java.util.StringJoiner;

public class Dozent extends Person {
    private String lehrgebiet;

    public Dozent(String vorname, String nachname, String lehrgebiet) {
        super(vorname, nachname);
        this.lehrgebiet = lehrgebiet;
    }

    public Dozent(String vorname, String nachname, String strassenname, String hausnummer, String ort, Integer postleitzahl, String lehrgebiet) {
        super(vorname, nachname, strassenname, hausnummer, ort, postleitzahl);
        this.lehrgebiet = lehrgebiet;
    }

    public String getLehrgebiet() {
        return lehrgebiet;
    }

    public void setLehrgebiet(String lehrgebiet) {
        this.lehrgebiet = lehrgebiet;
    }


    @Override
    public  String toString(){

        return "Dozent" + super.toString() + ", lehrgebiet=" + lehrgebiet + "}";
    }

    /*@Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "Dozent{", "}");
        joiner.add("vorname = " + vorname)
                .add("nachname = " + nachname);
        if (strassenname != null) {
            joiner.add("strassenname= " + strassenname);
        }
        if(hausnummer != null){
            joiner.add("hausnummer = " + hausnummer);
        }
        if(ort != null){
            joiner.add("ort = " + ort);
        }
        if(postleitzahl != null){
            joiner.add("postleitzahl = " + postleitzahl);

        }
        joiner.add("lehrgebiet = " + lehrgebiet);
        return joiner.toString();
    }*/

    public static void main(String[] args) {
        Dozent dozent = new Dozent("A", "B", "Science");
        dozent.setStrassenname("Street Mac");
        System.out.println(dozent);
    }
}
