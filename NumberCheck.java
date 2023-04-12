import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = sc.nextLine();
        boolean validInput = true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                validInput = false;
                break;
            }
        }
        if (!validInput) {
            System.out.println("INVALID INPUT.");
            return;
        }
        int n = Integer.parseInt(input);
        boolean increasing = true;
        boolean decreasing = true;
        int lastDigit = n % 10;
        n /= 10;
        while (n > 0) {
            int digit = n % 10;
            if (digit > lastDigit) {
                increasing = false;
            } else if (digit < lastDigit) {
                decreasing = false;
            }
            lastDigit = digit;
            n /= 10;
        }
        if (increasing) {
            System.out.println(input + " IS AN INCREASING NUMBER.");
        } else if (decreasing) {
            System.out.println(input + " IS A DECREASING NUMBER.");
        } else {
            System.out.println(input + " IS A BOUNCY NUMBER.");
        }
    }
}