import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] line = sc.nextLine().split("\\s+");
        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids,line);
        int num = sc.nextInt();

        while (kids.size() > 1) {

            for (int i = 0; i <num - 1 ; i++) {

                String curr = kids.poll();
                kids.offer(curr);

            }
            String removed=kids.poll();
            System.out.println("Removed "+ removed);
        }

        System.out.println("Last is "+kids.poll());

    }
}