package musterPruefung.enuum.Bestellverwaltungssystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BestellArchiv {

    private static final String FILENAME = "src/musterPruefung/enuum/Bestellverwaltungssystem/bestellungen.csv";
    private static final PrintWriter WRITER = initWriter();

    private static PrintWriter initWriter() {
        try {
            return new PrintWriter(FILENAME);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void bestellungSpeichern(Bestellung b) {
        String serialized = b.serialize();
        WRITER.append(serialized).append(System.lineSeparator());
        WRITER.flush();
    }

    public static List<Bestellung> ladeAlleBestellungen() {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(FILENAME));
            List<String> lines = fileReader.lines().toList();

            List<Bestellung> res = new ArrayList<>();
            for (String line : lines) {
                res.add(Bestellung.deserialize(line));
            }
            return res;
        }
        catch (Exception ex){
            throw new RuntimeException();
        }
    }

    public static Map<Product, Long> berechneVerkäufeProProdukt(){
        List<Bestellung> orders = ladeAlleBestellungen();
        Map<Product, Long> res = new LinkedHashMap<>();
        for (Bestellung order : orders) {
            for (Product product : order.getProdukte()) {
                res.compute(product, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        return res;
    }

    public static double berechneGesamteinnahmen(){
        List<Bestellung> orders = ladeAlleBestellungen();

        double res = 0.0;
        for (Bestellung order : orders) {
            for (Product product : order.getProdukte()) {
              res+= product.getCost();
            }
        }
        return res;
    }

}

