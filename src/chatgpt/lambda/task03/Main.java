package chatgpt.lambda.task03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(){{
            add("fghj"); add("yuik"); add("yutgf");
            add("ik"); add("pl,m"); add("asdfg");
        }};

        List<Integer> numbers = List.of(234,456,678,0,23,345678);

        List<Integer> leangthWord = mapList(words,x-> x.length());
        System.out.println("Words leangth: " + leangthWord);

        List<Integer> square = mapList(numbers, x-> x*x);
        System.out.println("Element by el: " + square);

    }

    //<T,R> Erlauterung von Typen (T und R) in methoden ist must-have
    public static <T,R> List<R> mapList(List<T> source, Function<T, R> mapper){
        List<R> res = new ArrayList<>();
        for (T element : source) {
            res.add(mapper.apply(element));
        }
        return res;
    }
}
