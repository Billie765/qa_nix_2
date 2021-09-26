import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static int numSentences(String data) {
        String[] sentences = data.split("[\\.!\\?]");
        return sentences.length;
    }

    public static int numPalindromes(String data) {
        String[] words = getWords(data);
        int result = 0;
        for (String word : words) {
            if (word.length() > 1 && word.equals(new StringBuilder(word).reverse().toString())) {
                result++;
            }
        }
        return result;
    }

    public static HashMap<String, Integer> wordOccurence(String data) {
        String[] words = getWords(data);
        HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
        for (String word : words) {
            int freq = freqMap.getOrDefault(word, 0);
            freqMap.put(word, ++freq);
        }
        return freqMap;
    }

    private static String[] getWords(String data) {
        data.replaceAll(System.getProperty("line.separator"), "");
        data = data.replaceAll("[\\.\\?!,:;-]", "");
        String[] words= data.split(" ");
        return words;
    }
}
