import java.util.*;

public class matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the matrix (N x N), where 3 < N < 10: ");
        int n = sc.nextInt();
        if (n <= 3 || n >= 10) {
            System.out.println("Invalid input. N must be greater than 3 and less than 10.");
            return;
        }
        int[][] matrix = new int[n][n];
        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Original matrix: ");
        printMatrix(matrix);
        
        // Sort the boundary elements
        int[] boundaryElements = new int[n * 4 - 4];
        int index = 0;
        for (int i = 0; i < n; i++) {
            boundaryElements[index++] = matrix[0][i];
            boundaryElements[index++] = matrix[n - 1][i];
        }
        for (int i = 1; i < n - 1; i++) {
            boundaryElements[index++] = matrix[i][0];
            boundaryElements[index++] = matrix[i][n - 1];
        }
        Arrays.sort(boundaryElements);
        
        // Rearrange the boundary elements in clockwise manner
        index = 0;
        for (int i = 0; i < n; i++) {
            matrix[0][i] = boundaryElements[index++];
        }
        for (int i = 1; i < n - 1; i++) {
            matrix[i][n - 1] = boundaryElements[index++];
        }
        for (int i = n - 1; i >= 0; i--) {
            matrix[n - 1][i] = boundaryElements[index++];
        }
        for (int i = n - 2; i > 0; i--) {
            matrix[i][0] = boundaryElements[index++];
        }
        
        System.out.println("Rearranged matrix: ");
        printMatrix(matrix);
        
        // Calculate the product of non-boundary elements
        int product = 1;
        System.out.println("Non-boundary elements: ");
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                product *= matrix[i][j];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Product of non-boundary elements: " + product);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}