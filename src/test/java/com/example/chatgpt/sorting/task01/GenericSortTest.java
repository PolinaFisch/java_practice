package com.example.chatgpt.sorting.task01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GenericSortTest {

    @Test
    @DisplayName("Сортировка списка строк с компаратором (лексикографический порядок)")
    void testSortWithComparator() {
        List<String> list = new ArrayList<>(List.of("banana", "apple", "pear", "orange"));
        Comparator<String> cmp = Comparator.naturalOrder();

        GenericSort.genericSort(list, cmp);

        assertEquals(List.of("apple", "banana", "orange", "pear"), list);
    }

    @Test
    @DisplayName("Сортировка списка чисел по естественному порядку")
    void testSortNaturalOrder() {
        List<Integer> list = new ArrayList<>(List.of(5, 2, 9, 1, 3));

        GenericSort.genericSort(list);

        assertEquals(List.of(1, 2, 3, 5, 9), list);
    }

    @Test
    @DisplayName("NullPointerException при null списке и компараторе")
    void testNullChecks() {
        assertThrows(NullPointerException.class, () -> GenericSort.genericSort(null, Comparator.naturalOrder()));
        assertThrows(NullPointerException.class, () -> GenericSort.genericSort(new ArrayList<>(), null));
        assertThrows(NullPointerException.class, () -> GenericSort.genericSort(null));
    }

    @Test
    @DisplayName("Сортировка с компаратором действительно упорядочивает список")
    void testSortOrderWithComparator() {
        List<String> list = new ArrayList<>(List.of("z", "x", "a", "m"));
        Comparator<String> cmp = Comparator.naturalOrder();

        GenericSort.genericSort(list, cmp);

        for (int i = 1; i < list.size(); i++) {
            assertTrue(cmp.compare(list.get(i - 1), list.get(i)) <= 0);
        }
    }

    @Test
    @DisplayName("Сортировка по естественному порядку действительно упорядочивает список")
    void testSortOrderNatural() {
        List<Integer> list = new ArrayList<>(List.of(10, 4, 6, 2));
        GenericSort.genericSort(list);

        for (int i = 1; i < list.size(); i++) {
            assertTrue(list.get(i - 1).compareTo(list.get(i)) <= 0);
        }
    }
}
