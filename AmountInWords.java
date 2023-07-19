import java.util.*;
public class AmountInWords 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Amount = ");
        double a = sc.nextDouble();
        if(a<0)
        {
            System.out.println("Amount must be positive");
            System.exit(0);
        }
        int r = (int)a;
        int p = (int)Math.round((a-r)*100);
        System.out.print("Amount = "+r+"."+p);
        if(p==0)
            System.out.print("0");
        
        String[] ones = {"","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
        String[] tens = {"","","TWENTY","THIRTY","FOURTY","FIFTY","SIXTY","SEVENTY","EIGHTY","NINTY"};
        String[] teens = {"TEN","ELEVEN","TWELVE","THIRTEEN","FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN"};
        String[] places = {"HUNDRED", "THOUSAND", "LAKH", "CRORE"};
        
        String ans = "";
        
        int crore = r / 10000000;
        r %= 10000000;
        
        if (crore != 0) {
            ans += convertTwoDigits(crore, ones, tens, teens) + " " + places[3] + " ";
        }
        
        int lakh = r / 100000;
        r %= 100000;
        
        if (lakh != 0) {
            ans += convertTwoDigits(lakh, ones, tens, teens) + " " + places[2] + " ";
        }
        
        int thousand = r / 1000;
        r %= 1000;
        
        if (thousand != 0) {
            ans += convertTwoDigits(thousand, ones, tens, teens) + " " + places[1] + " ";
        }
        
        int hundred = r / 100;
        r %= 100;
        
        if (hundred != 0) {
            ans += ones[hundred] + " " + places[0] + " ";
        }
        
        if (r != 0) {
            ans += convertTwoDigits(r, ones, tens, teens);
        }
        
        if(ans.length()==0)
            ans = "ZERO ";
            
        String paise = "";
        
        paise += convertTwoDigits(p, ones, tens, teens);
        
        if(paise.length()==0)
            paise = "ZERO ";
            
        System.out.println("\nRUPEES. "+ans+" AND "+paise+" PAISE ONLY");
    }
    
    public static String convertTwoDigits(int n, String[] ones, String[] tens, String[] teens) {
        
        String result = "";
        
        if (n >= 20) {
            result += tens[n/10] + " ";
            n %= 10;
            result += ones[n] + " ";
            
            return result.trim();
            
        } else if (n >= 10 && n < 20) {
            return teens[n-10];
            
        } else {
            return ones[n];
            
        }
    }
}
