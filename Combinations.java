import java.util.Scanner;

public class Combinations 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int N = sc.nextInt();
        int count = 0;
        for (int i = 0; i < Math.pow(2, N); i++) 
        {
            int sum = 0;
            for (int j = 0; j < N; j++) 
            {
                if ((i & (int)Math.pow(2, j)) != 0) 
                {
                    sum += j + 1;
                } 
                else 
                {
                    sum -= j + 1;
                }
            }
            if (sum == 0) 
            {
                for (int j = 0; j < N; j++) 
                {
                    if ((i & (int)Math.pow(2, j)) != 0) 
                    {
                        System.out.print((j + 1) + " ");
                    } 
                    else 
                    {
                        System.out.print(- (j + 1) + " ");
                    }
                }
                System.out.println();
                count++;
            }
        }
        System.out.println("Total number of combinations = " + count);
    }
}
