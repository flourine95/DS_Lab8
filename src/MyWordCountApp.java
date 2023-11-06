import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MyWordCountApp {
    // public static final String fileName = "data/hamlet.txt";
    public static final String fileName = "data/fit.txt";
    // <word, its occurences>
    private Map<String, Integer> map = new HashMap<>();

    // Load data from fileName into the above map (containing <word, its occurences>)
    // using the guide given in TestReadFile.java
    public void loadData() throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNext()) {
            String word = input.next();
            map.compute(word, (key, value) -> value == null ? 1 : value + 1);
        }
    }

    // Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
    public int countUnique() {
        // TODO
        return map.size();
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt)
    // In this method, we do not consider the order of tokens.
    public void printWordCounts() throws FileNotFoundException {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt) according to ascending order of tokens
    // Example: An - 3, Bug - 10, ...
    public void printWordCountsAlphabet() {
        Map<String, Integer> sort = new TreeMap<>(String::compareTo);
        sort.putAll(map);
        System.out.println(sort);
    }
}
