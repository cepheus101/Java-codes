import java.util.Scanner;

public class SentenceProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        if (!sentence.endsWith(".") && !sentence.endsWith("!") && !sentence.endsWith("?")) {
            System.out.println("INVALID SENTENCE");
            return;
        }
        sentence = sentence.trim().replaceAll("\\s+", " ");
        System.out.print("Enter the word to be inserted: ");
        String word = sc.nextLine();
        System.out.print("Enter the word position in the sentence: ");
        int position = sc.nextInt();
        String[] words = sentence.split(" ");
        String newSentence = "";
        for (int i = 0; i < words.length; i++) {
            if (i == position - 1) {
                newSentence += word + " ";
            }
            newSentence += words[i] + " ";
        }
        System.out.println("MODIFIED SENTENCE: "+newSentence.trim());
    }
}