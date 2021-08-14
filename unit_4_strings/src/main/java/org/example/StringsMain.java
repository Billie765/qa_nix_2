package org.example;

public class StringsMain {
    public static void main(String[] args) {
        System.out.println(ReverseString.reverse("hello world", true));
        System.out.println(ReverseString.reverse("hello world", false));
        System.out.println(ReverseString.reverse("hello world", "worl"));
        System.out.println(ReverseString.reverse("hello world", 3, 7));
    }
}
