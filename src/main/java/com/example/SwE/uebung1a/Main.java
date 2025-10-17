package com.example.SwE.uebung1a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Your number:");
        Scanner sc = new Scanner(System.in);
        Long numberToCheck = sc.nextLong();

        // binary search
        // [1 2 3 4 5 6 7 8 9 10]
        // [1 2 3 4 5]
        // [1 2]
        // [1]
        int count = 0;
        for (long i = 1; i <= numberToCheck ; i++) {
            if(numberToCheck % i == 0){
                count++;
            }
        }

        if(count == 2){
            System.out.printf("YES! Your number: (%s) is PrimZahl", numberToCheck);
        }
        else{
            System.out.printf("NO.... (%s) is not a Primzahl%n", numberToCheck);
        }
    }
}
