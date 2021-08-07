package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddNumbers {
    public void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String message = bufferedReader.readLine();
        System.out.println(message);
        String numbers = message.replaceAll("[^0-9]", "");
        System.out.println(numbers);
        int result = 0;
        char[] chars = numbers.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result += chars[i] - '0';
        }
        System.out.println(result);
    }
}
