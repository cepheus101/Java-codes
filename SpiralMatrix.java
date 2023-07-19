import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the matrix (2 <= N <= 10): ");
        int n = sc.nextInt();
        if (n < 2 || n > 10) {
            System.out.println("Invalid input. Please enter a value between 2 and 10.");
            return;
        }
        int[][] matrix = new int[n][n];
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Fill the matrix in a clockwise spiral");
            System.out.println("2. Fill the matrix in an anticlockwise spiral");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                fillSpiral(matrix, n, true);
                printMatrix(matrix, n);
            } else if (choice == 2) {
                fillSpiral(matrix, n, false);
                printMatrix(matrix, n);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid input. Please choose either option 1, option 2, or option 3.");
            }
        }
    }

    public static void fillSpiral(int[][] matrix, int n, boolean clockwise) {
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        int count = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            if (clockwise) {
                for (int i = colStart; i <= colEnd; i++) matrix[rowStart][i] = count++;
                rowStart++;
                for (int i = rowStart; i <= rowEnd; i++) matrix[i][colEnd] = count++;
                colEnd--;
                if (rowStart <= rowEnd) for (int i = colEnd; i >= colStart; i--) matrix[rowEnd][i] = count++;
                rowEnd--;
                if (colStart <= colEnd) for (int i = rowEnd; i >= rowStart; i--) matrix[i][colStart] = count++;
                colStart++;
            } else {
                for (int i = rowStart; i <= rowEnd; i++) matrix[i][colStart] = count++;
                colStart++;
                for (int i = colStart; i <= colEnd; i++) matrix[rowEnd][i] = count++;
                rowEnd--;
                if (colStart <= colEnd) for (int i = rowEnd; i >= rowStart; i--) matrix[i][colEnd] = count++;
                colEnd--;
                if (rowStart <= rowEnd) for (int i = colEnd; i >= colStart; i--) matrix[rowStart][i] = count++;
                rowStart++;
            }
        }
    }

    public static void printMatrix(int[][] matrix, int n) {
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                String strNum=Integer.toString(matrix[r][c]);
                System.out.print(strNum);
                for(int j=0;j<4-strNum.length();j++){
                    System.out.print(" ");
                }
                
            }
            System.out.println();
        }
    }
}
