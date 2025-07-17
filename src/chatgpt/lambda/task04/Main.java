package chatgpt.lambda.task04;

//Predicate

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main{
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(){{
            add(12);
            add(12345);
            add(56);
            add(99);
            add(4);
        }};
        List<Integer> newNumbers = filterList(numbers,x-> x%2==0);
        System.out.println("Even numbers: " + newNumbers);

        List<String> words = List.of("dfg","fugfd","hgfd","hgsghjkhgf","fff","uytr6");
        List<String> newWord = filterList(words,x-> x.length()>4);
        System.out.println("more than 4 chars" + newWord);


    }

    public static <T> List<T> filterList(List<T> source, Predicate<T> predicate){
        List<T> resList = new ArrayList<>();

        for (T el : source) {
            if(predicate.test(el)){
                resList.add(el);
            }
        }
        return resList;
    }


}


