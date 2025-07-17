package chatgpt.comparator.task03;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        findByName(products, "cheese")
                .ifPresentOrElse(
                        p -> System.out.println(p.getPrice()),
                        () -> System.out.println("Not found")
                );
        findByName(products, "chocolate")
                .ifPresentOrElse(
                        p -> System.out.println(p.getPrice()),
                        () -> System.out.println("Not found")
                );
        Product product = findByName(products, "chocolate").orElse(new Product("default", 0.0));
        System.out.println(product);
    }

    public static Optional<Product> findByName(List<Product> products, String name) {
        // complex code returns null
        return products.stream()
                .filter(x-> x.getName().equalsIgnoreCase(name))
                .findFirst();
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