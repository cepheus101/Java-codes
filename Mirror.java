import java.util.Scanner;

public class Mirror {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows (M): ");
        int M = sc.nextInt();
        System.out.print("Enter the number of columns (N): ");
        int N = sc.nextInt();
        
        if (M <= 2 || M >= 10 || N <= 2 || N >= 10) {
            System.out.println("INVALID INPUT");
            return;
        }
        
        int[][] A = new int[M][N];
        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (sc.hasNextInt())
                {
                    A[i][j] = sc.nextInt();
                }
                else
                {
                    System.out.println("INVALID INPUT");
                    System.exit(0);
                }
            }
        }
        
        System.out.println("ORIGINAL MATRIX");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] >= 0) {
                    System.out.print(" " + A[i][j] + "   ");
                } else {
                    System.out.print(A[i][j] + "   ");
                }
            }
            System.out.println();
        }
        
        System.out.println("MIRROR MATRIX");
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (A[i][j] >= 0) {
                    System.out.print(" " + A[i][j] + "   ");
                } else {
                    System.out.print(A[i][j] + "   ");
                }
            }
            System.out.println();
        }
        
        int sum = A[0][0] + A[0][N - 1] + A[M - 1][0] + A[M - 1][N - 1];
        System.out.println("SUM OF THE CORNER ELEMENTS = " + sum);
    }
}