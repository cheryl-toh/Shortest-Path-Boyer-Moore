import java.util.Arrays;

public class BoyerMooreExample {
    public static void main(String[] args) {

        //initialize text and pattern
        char[] text = "ABAAAABAACD".toCharArray();
        char[] pattern = "ABA".toCharArray();

        //print information
        System.out.println("Text: " + Arrays.toString(text));
        System.out.println("Pattern: " + Arrays.toString(pattern));
        System.out.println();

        //start search
        BoyerMooreAlgorithm BoyerMoore = new BoyerMooreAlgorithm();
        BoyerMoore.search(text, pattern);
    }
}