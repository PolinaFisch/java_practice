package musterPruefung.minitasks.el12;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 12, 13, 14, 22);

        System.out.println(getString(numbers));
    }


    public static String getString(List<Integer> list) {
        return list.stream().map(x -> {
            if (x % 2 == 0) {
                return "e" + x.toString();
            } else {
                return "o" + x;
            }
        }).collect(Collectors.joining(","));

        /*return list.stream().map(x -> {
            if (x % 2 == 0) {
                return "e" + x.toString();
            } else {
                return "o" + x;
            }
        }).reduce((x, y) -> x + "," + y).get();*/
    }
}


