import java.io.IOException;

public class IOMain {

    public static void main(String[] args) throws IOException {

        IOFileService fileService = new IOFileService();
        String data = fileService.readFile("input.txt");
        fileService.createWriteFile("output.txt", StringUtil.wordOccurence(data), StringUtil.numPalindromes(data), StringUtil.numSentences(data));
    }
}
