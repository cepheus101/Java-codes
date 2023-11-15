import java.util.Scanner;

public class Matrix90 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("M = ");
        int M = scanner.nextInt();

        if (M < 3 || M > 9) {
            System.out.println("Invalid input. M must be greater than 2 and less than 10.");
            return;
        }

        int[][] A = new int[M][M];
        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        System.out.println("ORIGINAL MATRIX");
        printMatrix(A, M);

        System.out.println("MATRIX AFTER ROTATION");
        A = rotateMatrix(A, M);
        printMatrix(A, M);

        int sum = A[0][0] + A[0][M-1] + A[M-1][0] + A[M-1][M-1];
        System.out.println("Sum of the corner elements = " + sum);
    }

    private static void printMatrix(int[][] A, int M) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotateMatrix(int[][] A, int M) {
        int[][] B = new int[M][M];
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < M; ++j) {
                B[j][M-1-i] = A[i][j];
            }
        }
        return B;
    }
}
