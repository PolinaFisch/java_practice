package chatgpt.comparator.HA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        Comparator<Product> priceComparator = Comparator.comparingDouble(Product::getPrice);
        products.stream().filter(x -> x.getPrice() >= 50)
                .sorted(priceComparator.reversed()).limit(3)
                .forEach(System.out::println);

        products.stream().max(priceComparator).ifPresentOrElse(
                res -> System.out.println("most expensive item: " + res),
                () -> System.out.println("Empty list.")
        );
        System.out.println("average price: " + String.format("%.3f", products.stream().collect(Collectors.averagingDouble(Product::getPrice))));
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
