package com.example.chatgpt.exceptions.task03;

import com.example.chatgpt.exceptions.Task02.BadInputException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            int sum = sumPositiveIntsFromFile("src/chatgpt/exceptions/task03/input.txt");
            System.out.println(sum);
        } catch (DataProcessingException e) {
            System.err.println(e.getMessage());
            e.getCause().printStackTrace();
        }
    }

    public static int sumPositiveIntsFromFile(String fileName) throws DataProcessingException {
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                sum += com.example.chatgpt.exceptions.Task02.Main.parsePositiveInt(oneLine);
            }
            return sum;
        } catch (IOException | BadInputException ex) {
            throw new DataProcessingException("Ошибка обработки файла " + fileName, ex);
        }
    }


}

class DataProcessingException extends Exception {
    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

