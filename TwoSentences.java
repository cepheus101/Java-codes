import java.util.*;
public class TwoSentences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph containing two sentences only: ");
        String paragraph = sc.nextLine();
        String[] sentences = paragraph.split("[.!?]");
        if (sentences.length != 2) {
            System.out.println("INVALID PARAGRAPH");
            return;
        }
        String[] sentence1 = sentences[0].trim().split(" ");
        String[] sentence2 = sentences[1].trim().split(" ");
        System.out.println("SENTENCE 1: " + sentence1.length + " WORDS");
        System.out.println("SENTENCE 2: " + sentence2.length + " WORDS");
        StringBuilder commonWords = new StringBuilder();
        for (String word1 : sentence1) {
            for (String word2 : sentence2) {
                if (word1.equals(word2) && !commonWords.toString().contains(word1)) {
                    commonWords.append(word1).append(" ");
                    break;
                }
            }
        }
        System.out.print("COMMON WORDS: " + commonWords.toString());
    }
}