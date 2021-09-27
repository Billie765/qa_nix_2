import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtil {

    public static int numSentences(String data) {
        String[] sentences = data.split("[\\.!\\?]");
        return sentences.length - 1;
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
        return sortByValue(freqMap, false);
    }

    private static String[] getWords(String data) {
        data = data.replaceAll(System.getProperty("line.separator"), "");
        data = data.replaceAll("[\\.\\?!,:;-]", "");
        String[] words= data.split(" ");
        return words;
    }

    private static HashMap<String, Integer> sortByValue(HashMap<String, Integer> unsortMap, final boolean order)
    {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }
}
