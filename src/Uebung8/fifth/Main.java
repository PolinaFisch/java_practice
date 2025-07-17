package Uebung8.fifth;

import java.util.Arrays;

class Person {

    private final String firstName;
    private String lastName;
    private final int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Person(String f, String l, int a) {
        firstName = f;
        lastName = l;
        age = a;
    }

    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
    }
}


class PersonTest {

    public static void testPerson() {
        Person[] people = new Person[] { new Person("Ted", "Neward", 41),
                new Person("Charlotte", "Neward", 41),
                new Person("Michael", "Neward", 19),
                new Person("Matthew", "Neward", 13),
                new Person("Adam", "Pfeiffer", 43) };

        // 3 Varianten einfügen...
        /*Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };*/
        Arrays.sort(people, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        Arrays.sort(people, (x,y) -> x.getLastName().compareTo(y.getLastName()) );
        Arrays.sort(people, (person1, person2) -> Integer.compare(person1.getAge(), person2.getAge()));

        for (Person person : people) {
            System.out.println(person);
        }

        //System.out.println(Arrays.toString(people));
    }

    public static void main(String[] args) {
        testPerson();
    }
}
