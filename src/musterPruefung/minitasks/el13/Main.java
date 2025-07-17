package musterPruefung.minitasks.el13;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    static List<Integer> numb = List.of(5, 10, 3, 11, 9, 10, 20);

    public static void main(String[] args) {

        System.out.println(findFirst(numb, 0, numb.size(), x -> {
            for (Integer num : numb) {
                boolean condition = true;
                for (int i = 2; i <= num; i++) {
                    if (x % i == 0 && num % i == 0) {
                        condition = false;
                        break;
                    }
                }
                if (condition) {
                    return true;
                }
            }
            return false;
        }));

    }

    public static <T> int findFirst(List<T> list, int begin, int end, Predicate<T> p) {
        for (int i = begin; i < end; i++) {
            if (p.test(list.get(i))) {
                return i;
            }
        }
        return -1;
    }

}
