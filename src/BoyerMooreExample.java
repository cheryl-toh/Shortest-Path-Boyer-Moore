import java.util.Arrays;

public class BoyerMooreExample {
    public static void main(String[] args) {

        char[] text = "ABAAAABAACD".toCharArray();
        char[] pattern = "ABA".toCharArray();

        System.out.println("Text: " + Arrays.toString(text));
        System.out.println("Pattern: " + Arrays.toString(pattern));
        System.out.println();

        BoyerMooreAlgorithm BoyerMoore = new BoyerMooreAlgorithm();
        BoyerMoore.search(text, pattern);
    }
}