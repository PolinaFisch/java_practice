package com.example.chatgpt.generics.task05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SwapUtilTest {

    @Test
    void testSwap_success() {
        var list = new ArrayList<>(List.of("str1", "str2", "str3"));

        SwapUtil.swap(list, 0, 1);

        assertEquals(List.of("str2", "str1", "str3"), list);
    }

    @Test
    @DisplayName("Проверка на пустой список")
    void testSwap_emptyList() {
        assertThrows(IllegalArgumentException.class, () -> SwapUtil.swap(Collections.emptyList(), 1, 2));
    }

    @Test
    void testSwap_indexOutOfBounds() {
        var list = new ArrayList<>(List.of(1, 2, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> SwapUtil.swap(list, 0, 3));
    }

    @Test
    void testSwap_UnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> SwapUtil.swap(List.of(1, 2, 3), 0, 1));
    }

    @Test
    void testSwap_equalIndices() {
        var list = new ArrayList<>(List.of(1, 2, 3));
        SwapUtil.swap(list, 1,  1);
        assertEquals(List.of(1, 2, 3), list);
    }

    @Test
    @DisplayName("Reverse List<String> с чётным числом элементов")
    void testReverseStringListEven() {
        List<String> list = new ArrayList<>(List.of("a", "b", "c", "d"));
        SwapUtil.reverse(list);
        assertEquals(List.of("d", "c", "b", "a"), list);
    }

    @Test
    @DisplayName("Reverse List<Integer> с нечётным числом элементов")
    void testReverseIntegerListOdd() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        SwapUtil.reverse(list);
        assertEquals(List.of(3, 2, 1), list);
    }

    @Test
    @DisplayName("Reverse пустого списка")
    void testReverseEmptyList() {
        List<Object> list = new ArrayList<>();
        SwapUtil.reverse(list);
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Reverse списка из одного элемента")
    void testReverseSingleElementList() {
        List<String> list = new ArrayList<>(List.of("only"));
        SwapUtil.reverse(list);
        assertEquals(List.of("only"), list);
    }

    @Test
    @DisplayName("Reverse списка с null элементом")
    void testReverseListWithNull() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null);
        list.add(3);
        SwapUtil.reverse(list);
        assertEquals(Arrays.asList(3, null, 1), list);
    }

    @Test
    @DisplayName("Reverse немодифицируемого списка должен бросить UnsupportedOperationException")
    void testReverseUnmodifiableList() {
        List<Integer> unmodifiableList = List.of(1, 2, 3);
        assertThrows(UnsupportedOperationException.class, () -> SwapUtil.reverse(unmodifiableList));
    }

    @Test
    @DisplayName("Reverse с null списком должен бросить NullPointerException")
    void testReverseNullList() {
        assertThrows(NullPointerException.class, () -> SwapUtil.reverse(null));
    }
}