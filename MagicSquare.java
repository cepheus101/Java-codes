import java.util.Scanner;

public class MagicSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.println("N must be an odd number.");
            return;
        }
        int[][] magicSquare = new int[n][n];
        int row = n / 2;
        int col = n - 1;
        for (int num = 1; num <= n * n; ) {
            if (row == -1 && col == n) {
                col = n - 2;
                row = 0;
            } else {
                if (col == n)
                    col = 0;
                if (row < 0)
                    row = n - 1;
            }
            if (magicSquare[row][col] != 0) {
                col -= 2;
                row++;
                continue;
            } else
                magicSquare[row][col] = num++;
            col++;
            row--;
        }       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(magicSquare[i][j] + "\t");
            System.out.println();
        }
        int sum = n * (n * n + 1) / 2;
        System.out.println("SUM = " + sum);
    }
}
