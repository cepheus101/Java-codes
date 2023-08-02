import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N = ");
        int N = scanner.nextInt();
        System.out.println("Output:");
        int count = 0;
        int max = (int) Math.pow(2, N);
        for (int i = 0; i < max; i++) {
            int sum = 0;
            String combination = "";
            int temp = i;
            for (int j = 0; j < N; j++) {
                if (temp % 2 == 1) {
                    sum += j + 1;
                    combination += " " + (j + 1);
                } else {
                    sum -= j + 1;
                    combination += " -" + (j + 1);
                }
                temp /= 2;
            }
            if (sum == 0) {
                System.out.println(combination.trim());
                count++;
            }
        }
        System.out.println("Total number of combinations = " + count);
    }
}
