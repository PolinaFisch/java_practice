package chatgpt.generics.task02;

public class Main {
    public static void main(String[] args) {

        Pair<Integer> compNumb = new Pair<>(10, 5);
        System.out.println(compNumb.getMax());

        Pair<String> compStr = new Pair<>("Mama", "Aaaa");
        System.out.println(compStr.getMax());
            }
}

class Pair<T extends Comparable<T>> {

    private T first;
    private T second;

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getMax(){
        return first.compareTo(second) > 0 ? first : second;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }
}
