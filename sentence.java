import java.util.Scanner;

public class sentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph containing two sentences only:");
        String para = sc.nextLine();
        String[] sentences = para.split("[.?!]");
        if (sentences.length != 2) {
            System.out.println("Invalid paragraph");
            return;
        }
        String[] sentence1 = sentences[0].split("\\s+");
        String[] sentence2 = sentences[1].split("\\s+");
        int len1 = sentence1.length;
        int len2 = sentence2.length;
        System.out.println("Length of sentence 1: " + len1);
        System.out.println("Length of sentence 2: " + len2);
        System.out.print("Common words: ");
        for (String word : sentence1) {
            for (String word2 : sentence2) {
                if (word.equalsIgnoreCase(word2)) {
                    System.out.print(word + " ");
                }
            }
        }
    }
}