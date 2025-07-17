package chatgpt.comparator.task01;

//Comporator vs Comparable

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>(){{
            add(new Person(33, "B"));
            add(new Person(11, "D"));
            add(new Person(13, "C"));
            add(new Person(20, "E"));
            add(new Person(19, "A"));
            add(new Person(11, "A"));
        }};



        Comparator<Person> nameComparator = (x,y) -> x.getName().compareTo(y.getName());
        //or
        //Comparator<Person> nameComparator = Comparator.comparing(Person::getName);
        //compareTo - method from String
        System.out.println("Age comp");
        Collections.sort(persons, new AgeComparator());
        //persons.sort(new AgeComparator());
        System.out.println(persons);

        System.out.println("Name comp");
        persons.sort(nameComparator);
        System.out.println(persons);

        System.out.println("Age then name sort:");
        persons.sort(new AgeComparator().thenComparing(nameComparator));
        System.out.println(persons);
    }
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge()> o2.getAge()){
            return 1;
        } else if (o1.getAge() == o2.getAge()) {
            return 0;
        }
        else {
            return -1;
        }

        // or just:
        //return Integer.compare(o1.getAge(), o2.getAge());
        //or:
        //return (o1.getAge() < o2.getAge()) ? -1 : ((o1.getAge() == o2.getAge()) ? 0 : 1);
    }


}

class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
