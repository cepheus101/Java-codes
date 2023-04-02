import java.util.Scanner;

public class CompositeMagicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("m=");
        int m = sc.nextInt();
        System.out.print("n=");
        int n = sc.nextInt();
        if (m >= n) {
            System.out.println("Invalid input");
            return;
        }
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (isComposite(i) && isMagic(i)) {
                count++;
                result.append(i).append(", ");
            }
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }
        System.out.println("The Composite Magic Integers are: " + result);
        System.out.println("Frequency of Composite Magic Integers is: " + count);
    }

    public static boolean isComposite(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count > 2;
    }

    public static boolean isMagic(int n) {
        while (n > 9) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}