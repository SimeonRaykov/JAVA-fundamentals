import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayDeque<Integer>deck =new ArrayDeque<>();
        int numbersToAdd=sc.nextInt();
        int numbersToRemove=sc.nextInt();
        int numberToCheck=sc.nextInt();
        sc.nextLine();
        String []nums=sc.nextLine().split("\\s+");

        for (int i = 0; i <numbersToAdd ; i++) {
            deck.offer(Integer.parseInt(nums[i]));
        }
        for (int i = 0; i <numbersToRemove ; i++) {
            deck.poll();
        }
        if(deck.isEmpty()){
            System.out.println(0);
        }
        else if(deck.contains(numberToCheck)){
            System.out.println(true);
        }
        else{
            System.out.println(Collections.min(deck));
        }

    }
}
