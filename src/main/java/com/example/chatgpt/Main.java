package com.example.chatgpt;
//Полиморфизм и наследование
//Interface
//enum

public class Main {
    public static void main(String[] args) {

        //demands 2 arguments now (because constructor has 2), but it was already in constructor spesified
        Movable[] movers = {new Cat("cat1"), new Cat("cat2"), new Dog("dog1"),
        new Dog("dog2"), new Bird("bird1"), new Bird("bird2")};
        for (Movable mover : movers) {
            show((Animal) mover);
        }


    }

    static void show(Animal a) {
        System.out.println(a);
        a.makeSound();
        a.move();
        System.out.println();
    }
}

abstract class Animal implements Movable {
    private String name;

    private Diet diet; //Class Diet exists below

    private FeedingStrategy feedingStrateg;

    public Animal(String name, Diet diet, FeedingStrategy feedingStrateg){
        this.name = name;
        this.diet = diet;
        this.feedingStrateg = feedingStrateg;
    }

    public String getName() {
        return name;
    }
    public Diet getDiet(){
        return diet;
    }

    public void feed(){
        feedingStrateg.feed(this); //Что это и почему выглядит так, класс у кт вызывается метод, но класса не существует
    }


    public abstract void makeSound();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " \"" + name + "\"";
    }

}

class Dog extends Animal {

    public Dog(String name){
        super(name, Diet.CARNIVORE, new CarnivoreFeeding() );
    }

    @Override
    public void makeSound(){
        System.out.println("Woof");
    }

    @Override
    public void move(){
        System.out.println("Пёс " + getName() + " бежит");
    }
}

class  Cat extends  Animal {

    public Cat(String name){
        super(name, Diet.CARNIVORE, new CarnivoreFeeding());
    }

    @Override
    public void makeSound(){
        System.out.println("Meau");
    }

    @Override
    public void move(){
        System.out.println("Кот " + getName() + " крадётся");
    }
}

class  Bird extends  Animal {

    public Bird(String name){ //One that user changes
        super(name, Diet.HERBIVORE, new HerbivoreFeeding());//Second specified for parent class, no need for user to claim
    }

    @Override
    public void makeSound() {
        System.out.println("Chick");
    }

    @Override
    public void move() {
        System.out.println("Птица " + getName() + " летит.");
    }
}

interface Movable {
    void move();
}
interface FeedingStrategy{
    void feed(Animal someAnimal);
}

class CarnivoreFeeding implements FeedingStrategy{
    @Override
    public void feed(Animal animal){
        System.out.println("ест птицу, говядину, молоко");
    }

}
class HerbivoreFeeding implements FeedingStrategy{
    @Override
    public void feed(Animal animal){
        System.out.println("ест клюкву, орехи");
    }

}
class OmnivoreFeeding implements FeedingStrategy{
    @Override
    public void feed(Animal animal){
        System.out.println("ест мясо, молочные продукты, овощи");
    }
}



enum Diet { //not public, because only one public class in ... .java

    CARNIVORE("Питается мясом"), // Type Diet
    HERBIVORE("Питается растениями"),
    OMNIVORE("Всеядное");

    //Constructor in order to init fields above: (.....)
    private final String description; //Type String
    Diet(String description){ //why not public?
        this.description = description;
    }
    public String getDescription(){
        return description;
    }



}