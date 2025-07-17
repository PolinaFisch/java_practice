package chatgpt.generics;

public class Main {
    public static void main(String[] args) {
        Box<String> anyText = new Box<>("ghjklkjhgfdf");//можно сразу не инит?
        Box<Integer> anyNumber = new Box<>(4567);//many

        System.out.println(anyText.get());
        Box.inspect(anyText);

        System.out.println(anyNumber.get());
        Box.inspect(anyNumber);
    }

}


class Box<T>{
    private T value;


    public Box(T value){
        this.value = value;
    }


    public static <U> void inspect(Box<U> box){
        System.out.println(box.get().getClass().getName());
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}