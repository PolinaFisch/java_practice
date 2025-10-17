package com.example.chatgpt.data_structures.stack.task01;

import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void pushAndPeek() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        assertEquals(10, stack.peek());
        stack.push(20);
        assertEquals(20, stack.peek());
    }

    @Test
    void pushAndPop() {
        MyStack<String> stack = new MyStack<>();
        stack.push("A");
        stack.push("B");
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    void isEmptyWorks() {
        MyStack<Integer> stack = new MyStack<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void sizeWorks() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    void popFromEmptyThrows() {
        MyStack<Integer> stack = new MyStack<>();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void peekFromEmptyThrows() {
        MyStack<Integer> stack = new MyStack<>();
        assertThrows(EmptyStackException.class, stack::peek);
    }
}
