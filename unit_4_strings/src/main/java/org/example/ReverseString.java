package org.example;

public class ReverseString {

    private static String reverseString(String str) {
        char[] array = str.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result += array[i];
        }
        return result;
    }

    private static String reverseWords(String str) {
        String[] words = str.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i ++) {
            result = result + " " + reverseString(words[i]);
        }
        return result.trim();
    }

    public static String reverse(String str, boolean reverseAll) {
        if (reverseAll) {
            return reverseString(str);
        }
        else {
            return reverseWords(str);
        }
    }

    public static String reverse(String str, String substr) {
        return str.replace(substr, reverse(substr, true));
    }

    public static String reverse(String str, int start, int end) {
        String sub = str.substring(start, end + 1);
        String result = reverseWords(sub);
        return str.replace(sub, result);
    }
}
