package com.example.chatgpt.lambda.task06;
/*
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> words = List.of("level", "world", "radar", "java", "kayak");

        // 1. Проверка – строка является палиндромом?
        Predicate<String> isPalindrome = x->
                x.equalsIgnoreCase(new StringBuilder(x).reverse().toString());

        // 2. Построить частотный словарь символов строки
        Function<String, Map<Character,Integer>> charFrequency = x->


        // 3. Печать словаря частот
        Consumer<Map<Character,Integer>> printCharFrequency = x->
                System.out.println(x.containsKey(Fr) ? );

        // 4. Фильтрация списка по предикату
        BiFunction<List<String>, Predicate<String>, List<String>> filterList =


                // 5. Поставщик нового списка
                Supplier<List<String>> listSupplier = x-> new List<String>().forEach(x);

        // A) Найди все палиндромы:
        List<String> pals = filterList.apply(words, isPalindrome);
        System.out.println("Палиндромы: " + pals);

        // B) Для каждого палиндрома построй и распечатай частоты:
        for (String p : pals) {
            Map<Character,Integer> freq = charFrequency.apply(p);
            System.out.println("Слово: " + p);
            printCharFrequency.accept(freq);
            System.out.println();
        }

        // C) С помощью listSupplier создай новый пустой список
        List<String> custom = listSupplier.get();
        custom.addAll(pals);
        System.out.println("Новый список из палиндромов: " + custom);
    }





}*/