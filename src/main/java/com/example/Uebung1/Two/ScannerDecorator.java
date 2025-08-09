package com.example.Uebung1.Two;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerDecorator {

    private Scanner scanner;

    public ScannerDecorator() {
        scanner = new Scanner(System.in);
    }

    public long nextLong() {
        try {
            return scanner.nextLong();
        } catch (InputMismatchException e) {
            throw new RuntimeException("Invalid format for input long.", e);
        }
    }

    public double nextDouble(){
        try {
            return scanner.nextDouble();
        }
        catch (InputMismatchException e){
            throw new RuntimeException("Invalid format for input double.", e);
        }
    }
}
