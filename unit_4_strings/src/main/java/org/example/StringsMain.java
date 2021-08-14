package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringsMain {

    public static void main(String[] args) throws IOException {
        byte input = 0;
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Press 1 to reverse full string.");
            System.out.println("Press 2 to reverse words in a string.");
            System.out.println("Press 3 to reverse substring in a string.");
            System.out.println("Press 4 to reverse substring based on start and finish indexes.");
            System.out.println("Press 5 to exit");
            try {
                input = Byte.parseByte(bufferedReader.readLine());
            } catch (NumberFormatException | IOException ex) {
                System.out.println("Sorry, incorrect format");
            }
            switch (input) {
                case 1 : {
                    System.out.println("Enter your string");
                    String s = bufferedReader.readLine();
                    System.out.println(ReverseString.reverse(s, true));
                } break;
                case 2 : {
                    System.out.println("Enter your string");
                    String s = bufferedReader.readLine();
                    System.out.println(ReverseString.reverse(s, false));
                } break;
                case 3 : {
                    System.out.println("Enter your string");
                    String s = bufferedReader.readLine();
                    System.out.println("Enter your substring");
                    String sub = bufferedReader.readLine();
                    System.out.println(ReverseString.reverse(s, sub));
                } break;
                case 4 : {
                    System.out.println("Enter your string");
                    String s = bufferedReader.readLine();
                    System.out.println("Enter your start index");
                    int start = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Enter your finish index");
                    int finish = Integer.parseInt(bufferedReader.readLine());
                    System.out.println(ReverseString.reverse(s, start, finish));
                } break;
                case 5 : {
                    System.out.println("Bye");
                    System.exit(0);
                }
            }
            System.out.println("_____________________");
        }
    }
}
