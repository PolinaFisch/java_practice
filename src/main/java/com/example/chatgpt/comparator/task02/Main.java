package com.example.chatgpt.comparator.task02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("milk", 33.0));
        products.add(new Product("bread", 12.6));
        products.add(new Product("eggs", 116.0));
        products.add(new Product("cheese", 753.9));
        products.add(new Product("kefir", 333.0));
        products.add(new Product("another bread", 122.0));
        System.out.println("original list: " + products);

        List<String> list = products.stream()
                .filter(x -> x.getPrice() >= 100)
                .map(Product::getName)
                .map(String::toUpperCase)
                .sorted()
                .toList();
        System.out.println(list);
        System.out.println(String.join(";\n", list));
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "[name: " + getName() + ", price: " + getPrice() + "] ";
    }
}
