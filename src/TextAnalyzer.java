import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class TextAnalyzer {
    // <word, its positions>
    private Map<String, ArrayList<Integer>> map = new HashMap<>();

    // load words in the text file given by fileName and store into map by using add
    // method in Task 2.1.
    // Using BufferedReader reffered in file TextFileUtils.java
    public void load(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int index = 0;
        while (true) {
            line = reader.readLine();
            if (line == null)
                break;
            StringTokenizer tokens = new StringTokenizer(line, " ");
            while (tokens.hasMoreTokens()) {
                index++;
                if (tokens.countTokens() == 1) {
                    index = -index;
                }
                add(tokens.nextToken(), index);
                if (index < 0) {
                    index = -index;
                }
            }
        }
        reader.close();
    }
    // In the following method, if the word is not in the map, then adding that word
    // to the map containing the position of the word in the file. If the word is
    // already in the map, then its word position is added to the list of word
    // positions for this word.
    // Remember to negate the word position if the word is at the end of a line in
    // the text file

    public void add(String word, int position) {
        ArrayList<Integer> values = map.getOrDefault(word, new ArrayList<>());
        values.add(position);
        map.put(word, values);
    }

    // This method should display the words of the text file along with the
    // positions of each word, one word per line, in alphabetical order
    public void displayWords() {
        Map<String, ArrayList<Integer>> sortAlpha = new TreeMap<>(String::compareTo);
        sortAlpha.putAll(map);
        System.out.printf("%-10s  %-30s %n", "Word", "Word Position(s)");
        System.out.println("=============================================");
        for (Entry<String, ArrayList<Integer>> entry : sortAlpha.entrySet()) {
            System.out.printf("|%-10s | %-30s %n", entry.getKey(), entry.getValue());
        }
    }

    // This method will display the content of the text file stored in the map
    public void displayText() {
        // count word in map
        /*
            |I          | [-3, -6, 9]
            |What       | [1, 4, 7]
            |deserve    | [12]
            |done       | [10]
            |have       | [2, 5, 8]
            |this       | [-13]
            |to         | [11]
            => count = 3 + 3 + 1 + 1 + 3 + 1 + 1
        */
        int count = map.values().stream().mapToInt(ArrayList::size).sum();
        String[] str = new String[count];
        for (Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            for (int i = 0, index, temp; i < entry.getValue().size(); i++) {
                temp = entry.getValue().get(i);
                if (temp > 0) {
                    index = temp - 1;
                    str[index] = entry.getKey() + " ";
                } else {
                    index = -temp - 1;
                    str[index] = entry.getKey() + "\n";
                }

            }
        }
        Arrays.stream(str).forEach(System.out::print);
    }

    // This method will return the word that occurs most frequently in the text file
    public String mostFrequentWord() {
        int valueMax = 0;
        String keyMax = "";
        for (Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > valueMax) {
                valueMax = entry.getValue().size();
                keyMax = entry.getKey();
            }
        }
        return keyMax;
    }

}
