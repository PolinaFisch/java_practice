package chatgpt.lambda.task01;

public class Main {
    public static void main(String[] args) {
        Operation add = (a, b) -> a + b;
        Operation subtract = (a, b) -> a - b;
        Operation multiply = (a, b) -> a * b;
        Operation divide = (a, b) -> {
            if (b == 0) {
                throw new IllegalArgumentException("division by zero");
            }
            return a/b;
        };
        System.out.println(add.apply(5, 3));
        System.out.println(subtract.apply(5, 3));
        System.out.println(multiply.apply(5, 3));
        System.out.println(divide.apply(567,0));
    }

}

@FunctionalInterface//AOP
interface Operation {
    int apply(int a, int b);

}