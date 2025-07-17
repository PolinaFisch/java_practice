package Uebung7.third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountList<E> extends ArrayList<E> {

    public CountList() {
        super();
    }

    public int count(E element) {
        /*AtomicInteger count = new AtomicInteger(0);
        forEach(x -> {
                    if (x.equals(element)) {
                        count.incrementAndGet();
                    }
                }
        );*/

        //Anstatt von for each
        /*int count = 0;
        Iterator<E> iterator = iterator();//universaler Weg Collection(Array/...) durchzugehen
        while (iterator.hasNext()) {
            E next = iterator.next();
            if (next.equals(element)) {
                count++;
            }
        }
        return count;*/

        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(element)) {
                count++;
            }
        }
        return count;
    }

    public int unique() {
        ArrayList<E> unic = new ArrayList<>();

        for (int i = 0; i < size(); i++) {
            if (!unic.contains(get(i))) {
                unic.add(get(i));
            }
        }
        return unic.size();//Anxahl von unic Elementen
    }

    /**
     * [str1, str2, str1, str3, str2, str4]
     * str1 -> 2
     * str2 -> 2
     * str3 -> 1
     * str4 -> 1
     * @return
     */
    public Map<E, Integer> counts() {
        Map<E, Integer> map = new HashMap<>();
        for (int i = 0; i < size(); i++) {
            E element = get(i);
            if (!map.containsKey(element)) {//containsKey
                map.put(element, count(element));
            }
        }
        return map;
    }


}

class Main {
    public static void main(String[] args) {
        CountList<String> list = new CountList<>();
        list.add("str1");
        list.add("str2");
        list.add("str1");
        list.add("str3");
        list.add("str2");
        list.add("str4");

        System.out.printf("str1 in list %d times%n", list.count("str1"));
        System.out.println("unique elements count: " + list.unique());

        Map<String, Integer> map = list.counts();
        System.out.println(map);
    }
}
