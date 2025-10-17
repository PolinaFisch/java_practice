package com.example.chatgpt.data_structures.stack.task01;

import java.util.EmptyStackException;

public class MyStack<T> {

    private T[] mas = (T[]) new Object[8];
    private int occupiedElements = 0;

    public void push(T item) {
        if (occupiedElements == mas.length) {
            resize(mas.length * 2);
        }
        mas[occupiedElements] = item;
        occupiedElements++;
    }

    public void resize(int newSize) {
        T[] newMas = (T[]) new Object[newSize];
        System.arraycopy(mas, 0, newMas, 0, occupiedElements);
        mas = newMas;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T lastElement = mas[occupiedElements - 1];
        mas[occupiedElements - 1] = null;
        occupiedElements--;
        //     *                     *
        // [1, 2, null, null]   ->  [1, null]
        if ((occupiedElements <= 0.25 * mas.length) && mas.length >= 4) {
            resize(mas.length / 2);
        }
        return lastElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return mas[occupiedElements - 1];
    }

    public boolean isEmpty() {
        return occupiedElements == 0;
    }

    public int size() {
        return occupiedElements;
    }
}
