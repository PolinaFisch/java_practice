package com.example.chatgpt.data_structures.queue.task01;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyQueueTest {

    @Test
    void enqueueAndPeek() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        assertEquals(10, queue.peek());
        queue.enqueue(20);
        assertEquals(10, queue.peek()); // peek не удаляет
    }

    @Test
    void enqueueAndDequeue() {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
    }

    @Test
    void isEmptyWorks() {
        MyQueue<Integer> queue = new MyQueue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    void sizeWorks() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    void enqueueAndDequeueInOrder() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void peekDoesNotRemove() {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");

        assertEquals("A", queue.peek());
        assertEquals("A", queue.peek()); // peek не удаляет
        assertEquals(2, queue.size());
    }

    @Test
    void dequeueFromEmptyThrows() {
        MyQueue<Integer> queue = new MyQueue<>();
        assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    @Test
    void peekFromEmptyThrows() {
        MyQueue<Integer> queue = new MyQueue<>();
        assertThrows(NoSuchElementException.class, queue::peek);
    }

    @Test
    void wrapAroundWorks() {
        MyQueue<Integer> queue = new MyQueue<>();

        // заполняем очередь полностью (8 элементов)
        for (int i = 1; i <= 8; i++) {
            queue.enqueue(i);
        }

        // удаляем первые 3 (start "сдвигается")
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());

        // добавляем новые элементы (должно пойти в начало массива по кругу)
        queue.enqueue(9);
        queue.enqueue(10);

        // проверяем порядок (FIFO!)
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(7, queue.dequeue());
        assertEquals(8, queue.dequeue());
        assertEquals(9, queue.dequeue());
        assertEquals(10, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void resizeUpWorks() {
        MyQueue<Integer> queue = new MyQueue<>();

        // вставляем больше 8 элементов (resize должен сработать)
        for (int i = 1; i <= 20; i++) {
            queue.enqueue(i);
        }

        assertEquals(20, queue.size());
        for (int i = 1; i <= 20; i++) {
            assertEquals(i, queue.dequeue());
        }
        assertTrue(queue.isEmpty());
    }

    @Test
    void resizeDownWorks() {
        MyQueue<Integer> queue = new MyQueue<>();

        for (int i = 1; i <= 16; i++) {
            queue.enqueue(i);
        }

        // удаляем 12 элементов, должно произойти сжатие
        for (int i = 1; i <= 12; i++) {
            assertEquals(i, queue.dequeue());
        }

        assertEquals(4, queue.size());
    }
}
