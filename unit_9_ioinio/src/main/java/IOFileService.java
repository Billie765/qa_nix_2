import java.io.*;
import java.util.HashMap;
import java.util.Map;



public class IOFileService {

    public void createFile(String filename) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            writer.write("Word occurrences:");
        }
    }

    public String readFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String everything = null;
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return everything;
    }

    public void createWriteFile(String filename, HashMap<String, Integer> wordOccurrence, int numPalindromes, int numSentences ) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            writer.write("Word occurrences:");
            writer.write(System.getProperty( "line.separator" ));
            for (Map.Entry<String,Integer> result : wordOccurrence.entrySet()) {
                writer.write(result.getKey() + " : " + result.getValue());
                writer.write(System.getProperty( "line.separator" ));
            }
            writer.write("------------------------------");
            writer.write(System.getProperty( "line.separator" ));
            writer.write("Number of palindromes: " + numPalindromes);
            writer.write(System.getProperty( "line.separator" ));
            writer.write("------------------------------");
            writer.write(System.getProperty( "line.separator" ));
            writer.write("Number of sentences: " + numSentences);
        }
    }
}