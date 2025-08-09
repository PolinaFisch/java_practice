package com.example.musterPruefung.enuum.Bestellverwaltungssystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bestellung {
    private UUID bestellId;
    private final String kunde;
    private LocalDateTime zeitstempel;
    private List<Product> produkte;

    public Bestellung(String kunde) {
        this.kunde = kunde;
        bestellId = UUID.randomUUID();
        zeitstempel = LocalDateTime.now();
        produkte = new ArrayList<>();
    }

    public Bestellung(UUID bestellId, String kunde, LocalDateTime zeitstempel) {
        this.bestellId = bestellId;
        this.kunde = kunde;
        this.zeitstempel = zeitstempel;
        produkte = new ArrayList<>();
    }

    public void produktHinzufügen(Product p){
        this.produkte.add(p);
    }

    public double berechneGesamtpreis(){
        double totalPrice = 0;
        for (Product product : produkte) {
            totalPrice += product.getCost();
        }
        return totalPrice;
    }

    public String serialize(){
        String result = String.format("%s,%s,%s,", bestellId, kunde, zeitstempel);
        for (Product product : produkte) {
            result += product.getName() + ";";
        }
        return result;
    }

    public static Bestellung deserialize(String zeile) {
        String[] components = zeile.split(",");
        UUID id = UUID.fromString(components[0].trim());
        String kunde = components[1];
        LocalDateTime ldt = LocalDateTime.parse(components[2]);

        Bestellung bestellung = new Bestellung(id, kunde, ldt);
        String[] productNames = components[3].split(";");
        for (String productName : productNames) {
            Product product = Product.fromString(productName).get();
            bestellung.produktHinzufügen(product);
        }

        return bestellung;
    }

    public List<Product> getProdukte() {
        return produkte;
    }

    @Override
    public String toString() {
        return "Bestellung{" +
                "id=" + bestellId +
                ", kunde='" + kunde + '\'' +
                ", zeit=" + zeitstempel +
                ", products=" + produkte +
                '}';
    }
}
