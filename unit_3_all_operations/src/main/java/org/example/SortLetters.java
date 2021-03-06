package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortLetters {

    public void run() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Task 2. Sort and count letters");
        System.out.println("Enter the string:");
        String message = bufferedReader.readLine();
        message = message.replaceAll("\\P{L}", "");
        char[] chars = message.toCharArray();
        if (chars.length == 0) {
            System.out.println("No alphabetic characters in line");
        } else {
            Arrays.sort(chars);
            int i = 0;
            char buffer = chars[0];
            int total = 0;
            while (i < chars.length) {
                if (buffer == chars[i]) {
                    total++;
                } else {
                    System.out.println(buffer + " - " + total);
                    buffer = chars[i];
                    total = 1;
                }
                i++;
            }
            System.out.println(buffer + " - " + total);
        }
        System.out.println("__________________________________");
    }
}
