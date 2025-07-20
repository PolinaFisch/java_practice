package chatgpt.collections.maps.task01;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        // 1) Частотный словарь
        String text = "Java и Java, и только Java!";
        Map<String,Integer> freq = MapUtils.wordFrequency(text);
        System.out.println("Word frequencies: " + freq);
        // Пример вывода: {java=3, и=2, только=1}

        // 2) Инверсия
        Map<String,Integer> sample = Map.of("A",1, "B",2, "C",1, "D",2);
        Map<Integer, List<String>> inv = MapUtils.invert(sample);
        System.out.println("Inverted: " + inv);
        // Ожидается: {1=[A, C], 2=[B, D]}

        // 3) Слияние с суммой
        Map<String,Integer> m1 = Map.of("x", 10, "y", 20);
        Map<String,Integer> m2 = Map.of("y", 5, "z", 15);
        Map<String,Integer> merged = MapUtils.mergeSum(m1, m2);
        System.out.println("Merged sum: " + merged);
        // Ожидается: {x=10, y=25, z=15}

        // 4) Безопасный get
        System.out.println("Get y: " + MapUtils.getOrThrow(merged, "y"));  // 25
        try {
            MapUtils.getOrThrow(merged, "w");
        } catch (NoSuchElementException ex) {
            System.out.println("Expected exception: " + ex.getMessage());
        }
    }

}
