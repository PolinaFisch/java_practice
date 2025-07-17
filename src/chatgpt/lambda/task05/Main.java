package chatgpt.lambda.task05;

//Consumer

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<String> words = List.of("apple", "banana", "cherry");

        System.out.println("== Работа с числами ==");
        forEachElement(numbers, n -> System.out.println("Число: " + n));

        System.out.println("\n== Работа со словами ==");
        forEachElement(words, w -> System.out.println("Слово длиной " + w.length() + ": " + w));

    }

    public static <T> void forEachElement(List<T> source, Consumer<T> action){
        for (T el : source) {
            action.accept(el);
        }
    }
}
