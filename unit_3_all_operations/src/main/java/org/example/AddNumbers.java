package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddNumbers {

    public void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Task 1. Sum of numbers in a string");
        System.out.println("Type the string:");
        String message = bufferedReader.readLine();
        String numbers = message.replaceAll("[^0-9]", "");
        int result = 0;
        char[] chars = numbers.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result += chars[i] - '0';
        }
        System.out.println(result);
        System.out.println("__________________________________");
    }
}
