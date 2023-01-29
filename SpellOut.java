import java.util.Scanner;

public class SpellOut {
    static String ones[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static String tens[] = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            int n = scan.nextInt();
            if (n < 10)
                System.out.println(ones[n]);
            else if (n < 100)
                tenPrint(n);
            else if (n < 1000)
                hundredPrint(n);
            else
                thousandPrint(n);
        }
    }
    static void tenPrint(int num){
        int one = num % 10;
        if(num<20)
            System.out.print(tens[num-10]);
        else if(one==0)
            System.out.print(tens[(num / 10) - 2 + 10]);
        else if(num<100) {
            System.out.print(tens[(num / 10) - 2 + 10] + "-" + ones[one]);
        }
    }
    static void hundredPrint(int num){
        int one = num % 10;
        int ten = num%100;
        int hundred = num/100;
        if(ten==0)
            System.out.print(ones[hundred]+ " hundred");
        else if(ten-one==0)
            System.out.print(ones[hundred]+" hundred "+ ones[one]);
        else {
            System.out.print(ones[hundred]+ " hundred ");
            tenPrint(ten);
        }
    }
    static void thousandPrint(int num){
        int one = num % 10;
        int ten = num%100;
        int hundred = num%1000;
        int thousand = num/1000;
        if(hundred==0)
            System.out.println(ones[thousand]+" thousand");
        else if(hundred-ten==0 && ten-one==0)
            System.out.println(ones[thousand]+" thousand "+ones[one]);
        else{
            if(ten==0) {
                tenPrint(num / 100);
                System.out.print(" hundred / ");
            }
            System.out.print(ones[thousand] + " thousand ");
            hundredPrint(hundred);
        }
    }
}