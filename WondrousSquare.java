import java.util.Scanner;

public class WondrousSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N=");
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        boolean isWondrousSquare = true;
        int sum = (n * (n * n + 1)) / 2;
        boolean[] usedNumbers = new boolean[n * n + 1];

        // Check rows, columns, and used numbers
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
                colSum += grid[j][i];
                usedNumbers[grid[i][j]] = true;
            }
            if (rowSum != sum || colSum != sum) {
                isWondrousSquare = false;
                break;
            }
        }

        // Check if all numbers are used
        for (int i = 1; i <= n * n; i++) {
            if (!usedNumbers[i]) {
                isWondrousSquare = false;
                break;
            }
        }

        if (isWondrousSquare) {
            System.out.println("YES IT REPRESENTS A WONDROUS SQUARE.");
        } else {
            System.out.println("NOT A WONDROUS SQUARE.");
        }

        System.out.println("PRIME\tROW INDEX\tCOLUMN INDEX");
        
        for(int prime=2;prime<=n*n;prime++){
            if(isPrime(prime)){
                boolean found=false;
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(grid[i][j]==prime){
                            System.out.println(prime + "\t" + i + "\t\t" + j);
                            found=true;
                            break;
                        }
                    }
                    if(found) break;
                }
            }
            
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
