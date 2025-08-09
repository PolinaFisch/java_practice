package com.example.Uebung4.One;

public class Main {

    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Student("Peter", "Müller", "Hauptstrasse", "4a", "Coburg", 96450, 455555);
        persons[1] = new Student("Peterdfg", "Müller", "Hauptstrasse", "4a", "Coburg", 96450, 455555);
        persons[2] = new Student("Peterdfg", "Müller", "Hauptstrasse", "4a", "Coburg", 96450, 455555);
//        persons[2] = new Person("A3", "B3");
        persons[3] = new Dozent("Hans", "Meyer", "Jenaerstrasse", "21", "Coburg",96450, "Betriebssysteme" );
        persons[4] = new Dozent("Hanssdf", "Meyer", "Jenaerstrasse", "21", "Coburg",96450, "Betriebssysteme" );

        for (Person person : persons) {//person is an el (+1, + 1) in array persons
            System.out.println(person);
        }
    }
}
