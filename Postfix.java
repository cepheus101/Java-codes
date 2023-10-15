import java.util.Scanner;

public class Postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Postfix Equation:");
        String equation = sc.nextLine();
        int[] values = new int[26];
        for (char c : equation.toCharArray()) {
            if (Character.isLetter(c)) {
                System.out.print("Enter value of " + c + ":");
                values[c - 'A'] = sc.nextInt();
            }
        }
        int result = evaluatePostfix(equation, values);
        System.out.print("Answer: " + result);
    }

    private static int evaluatePostfix(String equation, int[] values) {
        int[] stack = new int[equation.length()];
        int top = -1;
        for (char c : equation.toCharArray()) {
            if (Character.isLetter(c)) {
                stack[++top] = values[c - 'A'];
            } else {
                int operand2 = stack[top--];
                int operand1 = stack[top--];
                switch (c) {
                    case '+':
                        stack[++top] = operand1 + operand2;
                        break;
                    case '-':
                        stack[++top] = operand1 - operand2;
                        break;
                    case '*':
                        stack[++top] = operand1 * operand2;
                        break;
                    case '/':
                        stack[++top] = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid character: " + c);
                }
            }
        }
        return stack[top];
    }
}
