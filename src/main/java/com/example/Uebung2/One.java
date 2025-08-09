package com.example.Uebung2;

import java.util.Arrays;

public class One {

    /*public static void main(String[] args) {
        Integer num = Integer.valueOf(5);   // boxing
        Integer num2 = 5;
        Integer num3 = (Integer) 5;

        int unboxedNum = num.intValue();  //unboxing
        int unboxedNum1 = num;
        int unboxedNum2 = (int) num;
    }*/

    public static void main(String[] args) {
//        int[] array = {2000, 2, 45, 34, 100000, 345, 56, 78, 99, 756, 999, 0, 666, 2345, 7492, 22};
//        bubbleSort(array);
//        System.out.println(Arrays.toString(array));
        Integer[] array2 = {2000, 2, 45, 34, 100000, 345, 56, 78, 99, 756, 999, 0, 666, 2345, 7492, 22};
        bubbleSort(array2);
        System.out.println(Arrays.toString(array2));
    }

    /*public static void bubbleSort(Integer[] array) {
        // convert Integer[] -> int[]
        int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }

        // sort
        bubbleSort(array2);

        // convert int[] -> Integer[], copy in oroginal
        for (int i = 0; i < array.length; i++) {
            array[i] = array2[i];
        }
    }
*/
    public static void bubbleSort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}