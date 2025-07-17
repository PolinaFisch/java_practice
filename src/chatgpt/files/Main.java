package chatgpt.files;

//Задание 1 на файлы от чата гпт

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();

        Map<Integer, String> stringsfromDoc = new HashMap<>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String eachString;

            int count = 0;
            while ((eachString = file.readLine()) != null) {//BufferedReader has no size or length => no fori
                stringsfromDoc.put(++count, eachString);
            }

        } catch (Exception ex) {
            System.err.printf("No file or smth went wrong");
            ex.printStackTrace();
        }
        for (Integer key : stringsfromDoc.keySet()) {
            System.out.println(key + ": " + stringsfromDoc.get(key));
        }
    }
}

