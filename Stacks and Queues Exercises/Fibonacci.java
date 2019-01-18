import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first = 1;
        int temp = 0;
        int fibo=0;
        int n = Integer.parseInt(sc.nextLine());
if(n==0){
    n=1;
}
        for (int i = 0; i < n; i++) {
            fibo = first + temp;
            temp=first;
            first=fibo;
        }
        System.out.println(fibo);

    }
}
