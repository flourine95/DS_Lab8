import java.io.IOException;

public class TestTextAnalyzer {
    public static void main(String[] args) throws IOException {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        textAnalyzer.load("data/short.txt");
        textAnalyzer.displayWords();
        textAnalyzer.displayText();
        System.out.println("Most Frequently:" + textAnalyzer.mostFrequentWord());
    }
}
