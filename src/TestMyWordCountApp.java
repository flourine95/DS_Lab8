import java.io.FileNotFoundException;

public class TestMyWordCountApp {
    public static void main(String[] args) throws FileNotFoundException {
        MyWordCountApp myWordCountApp = new MyWordCountApp();
        myWordCountApp.loadData();
        System.out.println("Unique tokens: " + myWordCountApp.countUnique());
        myWordCountApp.printWordCounts();
        myWordCountApp.printWordCountsAlphabet();
    }
}
