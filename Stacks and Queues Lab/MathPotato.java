import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] line = sc.nextLine().split("\\s+");
        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids,line);
        int num = sc.nextInt();

        int m =1;

        while (kids.size() > 1) {

            for (int i = 0; i <num - 1 ; i++) {

                String curr = kids.poll();
                kids.offer(curr);

            }
            if(!isPrime(m)) {
                String removed = kids.poll();
                System.out.println("Removed " + removed);
                m+=1;
            }
            else{

                System.out.println("Prime "+ kids.element());
                m+=1;
            }
        }

        System.out.println("Last is "+kids.poll());

    }

    public static boolean isPrime(int n) {
        if(n==1){
            return false;
        }

        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
