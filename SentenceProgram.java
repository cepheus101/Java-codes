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
        String punctuation = sentence.substring(sentence.length() - 1);
        sentence = sentence.substring(0, sentence.length() - 1);
        sentence = sentence.trim().replaceAll("\\s+", " ");
        System.out.print("Enter the word to be inserted: ");
        String word = sc.nextLine();
        System.out.print("Enter the word position in the sentence: ");
        int position = sc.nextInt();
        if (position < 1) {
            System.out.println("INVALID POSITION");
            return;
        }
        String[] words = sentence.split(" ");
        if (position > words.length + 1) {
            System.out.println("INVALID POSITION");
            return;
        }
        String newSentence = "";
        for (int i = 0; i < words.length; i++) {
            if (i == position - 1) {
                newSentence += word + " ";
            }
            newSentence += words[i] + " ";
        }
        if(position == words.length + 1)
        {
            newSentence += word;
        }
        System.out.println("MODIFIED SENTENCE: "+newSentence.trim() + punctuation);
    }
}