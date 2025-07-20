package chatgpt.collections.lists.task02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h"));

        // 1) reverse
        ListUtilsSimple.reverse(data);
        System.out.println("Reversed: " + data);
        // Ожидается: [h, g, f, e, d, c, b, a]


        // 2) removeEveryNth
        ListUtilsSimple.removeEveryNth(data, 3);
        System.out.println("After removeEveryNth(3): " + data);
        // Ожидается: из [h,g,f,e,d,c,b,a] удаляем индексы 2,5… → [h, g, e, d, b, a]

        // 3) swap
        ListUtilsSimple.swap(data, 1, 4);
        System.out.println("After swap(1,4): " + data);
        // Ожидается: поменять элементы под индексами 1 и 4
        // (g <→ b) → [h, b, e, d, g, a]
    }

}

class ListUtilsSimple {

    /**
     * 1. Разворачивает список in‑place: первый элемент становится последним, второй — предпоследним и т.д.
     *
     * @param list список, который нужно развернуть
     * @throws IllegalArgumentException если list == null
     */
    public static <T> void reverse(List<T> list) {
        Collections.reverse(list); //Меняет исходный
        //list.reversed(); - возвращает новый список
    }


    /**
     * 2. Удаляет из списка каждый n‑й элемент, начиная с индекса n–1 (0‑based).
     * Например, при n=3 удалит элементы на позициях 2, 5, 8…
     *
     * @param list список, в котором удаляем
     * @param n    шаг удаления, n > 0
     * @throws IllegalArgumentException если list == null или n <= 0
     */
    public static <T> void removeEveryNth(List<T> list, int n) {
        /*List<T> temp = new ArrayList<>();
        for (int i = 2; i < list.size(); i+=n) {
            temp.add(list.get(i));
        }

        list.removeAll(temp);*/

        Iterator<T> iterator = list.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            iterator.next();
            if (count % n == 0) {
                iterator.remove();
            }
            count++;
        }
    }


    /**
     * 3. Меняет местами элементы в списке по индексам i и j.
     *
     * @param list список
     * @param i    первый индекс, 0 <= i < list.size()
     * @param j    второй индекс, 0 <= j < list.size()
     * @throws IllegalArgumentException если list == null или i/j вне диапазона
     */
    public static <T> void swap(List<T> list, int i, int j) {
        T el = list.get(j);
        list.set(j, list.get(i));
        list.set(i, el);
    }
}
