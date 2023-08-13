import java.util.*;

public class DeleteWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER A SENTENCE(IN UPPERCASE): ");
        String sentence = sc.nextLine();
        char lastChar = sentence.charAt(sentence.length() - 1);
        if (lastChar != '.' && lastChar != '?' && lastChar != '!') {
            System.out.println("INVALID INPUT.");
            return;
        }
        System.out.print("WORD TO BE DELETED: ");
        String word = sc.nextLine();
        System.out.print("WORD POSITION IN THE SENTENCE: ");
        int position = sc.nextInt();
        if (position <= 0) {
            System.out.println("INVALID INPUT.");
            return;
        }

        int wordCount = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                wordCount++;
            }
        }
        wordCount++;

        if (position > wordCount) {
            System.out.println("INVALID INPUT.");
            return;
        }

        String[] words = new String[wordCount];
        int index = 0;
        int start = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                words[index++] = sentence.substring(start, i);
                start = i + 1;
            }
        }
        words[index] = sentence.substring(start);

        String[] queue = new String[words.length];
        int front = 0;
        int rear = 0;
        for (int i = 0; i < words.length; i++) {
            queue[rear++] = words[i];
        }

        String result = "";
        int count = 0;
        while (front != rear) {
            count++;
            String w = queue[front++];
            if (count == position && w.equals(word)) {
                continue;
            }
            result += w + " ";
        }
        System.out.println(result.trim());
    }
}
