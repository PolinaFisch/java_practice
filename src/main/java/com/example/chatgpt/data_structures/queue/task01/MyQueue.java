package com.example.chatgpt.data_structures.queue.task01;

import java.util.NoSuchElementException;

public class MyQueue<T> {

    private T[] data = (T[]) new Object[8];
    private int end = 0;
    private int start = 0;
    private int size = 0;

    public void enqueue(T item) {
        data[end] = item;
        end++;
        size++;
        if (size != data.length && end == data.length) {
            end = 0;
        }
        if (size == data.length) {
            resize(data.length * 2);
        }
    }

    public void resize(int newSize) {
        T[] newMas = (T[]) new Object[newSize];
        int ptr = start;
        for (int i = 0; ptr != end; i++) {
            newMas[i] = data[ptr];
            ptr++;
            if (ptr == end) {
                break;
            }
            if (ptr == data.length) {
                ptr = 0;
            }
        }
        data = newMas;
        start = 0;
        end = size;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T firstElement = data[start];
        data[start] = null;
        start++;
        size--;
        if (start == data.length) {
            start = 0;
        }
        if ((size <= data.length / 4) && (data.length >= 4)) {
            resize(data.length / 2);
        }
        return firstElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return data[start];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
