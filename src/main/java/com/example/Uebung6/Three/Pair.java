package com.example.Uebung6.Three;

import java.util.Objects;
import java.util.Vector;

public class Pair<T, U> {
    private final T left;
    private final U right;

    public Pair(T left, U right) {
        this.left = left;
        this.right = right;
    }

    public static <R, V> Pair<R, V> of(R left, V right) {
        return new Pair<>(left, right);
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Pair<?, ?> pair)) return false;

        return Objects.equals(left, pair.left) && Objects.equals(right, pair.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.left, this.right);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", this.left, this.right);
    }

}

class Main {
    public static void main(String[] args) {
        Pair<Integer, String> obj1 = new Pair<>(10, "String");
        Pair<Integer, String> obj2 = Pair.of(11, "String");

        System.out.printf("obj1 hash code = %d, obj2 hash code = %d%n", obj1.hashCode(), obj2.hashCode());
        System.out.println(obj1.equals(obj2));


        System.out.println(obj1);

        Vector<Pair<String, Integer>> vector = new Vector<>();

        vector.add(new Pair<>("I", 1));
        vector.add(new Pair<>("V", 5));
        vector.add(new Pair<>("C", 100));
        vector.add(new Pair<>("II", 2));
        vector.add(new Pair<>("IX", 9));

        System.out.println(vector);
    }
}
