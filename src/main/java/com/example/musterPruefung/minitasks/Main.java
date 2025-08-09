package com.example.musterPruefung.minitasks;

//.stream.peek(..) - вывод в консоль
//Arrays.stream(SomeArray).
//but
//someList.stream().

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        double[] numb = {1, 3, 2, 5, 6, 2};
        System.out.println(ClassForInterface.counter(2).apply(numb));

    }

}

class ClassForInterface {
    public static final ArrayProcessor MAX = x -> Arrays.stream(x).max().getAsDouble();
    public static final ArrayProcessor MIN = x -> findMin(x);
    public static final ArrayProcessor SUM = x -> Arrays.stream(x).sum();
    public static final ArrayProcessor AVG = x -> Arrays.stream(x).average().getAsDouble();

    private static double findMin(double[] array) {
        return Arrays.stream(array)
                .min()
                .getAsDouble();
    }


    public static ArrayProcessor counter(double value) {
        return x -> Arrays.stream(x).filter(y -> y == value).count();
    }


}


class StringUtils {

    public static <T, R> List<R> transformedList(List<T> list, Function<T, R> func) {
        return list.stream().peek(x -> System.out.print(x + " ")).map(func).peek(System.out::println).toList();
    }


    public static <T> List<T> allMatches(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).toList();

        /*List<T> res = new ArrayList<>();
        list.forEach(item -> {
            if (predicate.test(item)) {
                res.add(item);
            }
        });
        return res;*/
    }
}