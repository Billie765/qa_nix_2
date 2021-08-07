package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Schedule {
    public void run() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Task 3. Lesson end time");
        byte lesson = 0;
        while ((lesson < 1) | (lesson > 10)) {
            System.out.println("Please enter lesson number between 1 and 10:");
            try {
                lesson = Byte.parseByte(bufferedReader.readLine());
            } catch (NumberFormatException ex) {
                System.out.println("Sorry, incorrect format");
            }
        }
        short result = (short) (lesson * 45 + lesson / 2 * 5 + (lesson - 1) / 2 * 5);
        System.out.println("The lesson finishes at:");
        if (result % 60 < 10){
            System.out.println(9 + result / 60 + ":0" + result % 60);
        }
        else {
            System.out.println(9 + result / 60 + ":" + result % 60);
        }
    }
}
