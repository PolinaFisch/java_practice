package musterPruefung.enuum.Bestellverwaltungssystem;

import java.util.Locale;
import java.util.Optional;

public enum Product{
    KAFFEE("Kaffee", 2.50),
    TEE("Tee", 2.00 ),
    SAFT("Saft", 3.00),
    KUCHEN("Kuchen", 3.50),
    SANDWICH("Sandwich", 4.50 );

    private final String name;
    private final double cost;

    Product(String name, double cost){
        this.name = name;
        this.cost = cost;
    }

    public String getName(){
        return name;
    }
    public double getCost() {
        return cost;
    }


    public static Optional<Product> fromString(String s){
        for (Product p : values()) {
            if (p.name().equalsIgnoreCase(s)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }



    @Override
    public String toString(){
        return String.format(Locale.ENGLISH, "%s{%s, %.2f€}",name(), name, cost);
    }


}
