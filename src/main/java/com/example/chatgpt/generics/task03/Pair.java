package com.example.chatgpt.generics.task03;

import java.util.Objects;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Pair<V, K> swap(){
        return new Pair<>(value, key);
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Pair<?, ?> pair)) return false;

        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public String toString() {
        return "(%s, %s)".formatted(key, value);
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("key", 111);
        System.out.println(pair1);
        Pair<Integer, String> pair2 = pair1.swap();
        System.out.println(pair2);
        Pair<String, Integer> pair3 = pair2.swap();
        assert pair1.equals(pair3);
    }
}
