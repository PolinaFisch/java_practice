package com.example.chatgpt.generics.task05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

}