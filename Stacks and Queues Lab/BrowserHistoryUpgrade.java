import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> deck = new ArrayDeque<String>();
        ArrayDeque<String> forwards = new ArrayDeque<>();
        String command = sc.nextLine();


        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (deck.size()>1) {
                    String last = deck.pop();
                    String current = deck.peek();
                    forwards.offer(last);
                    System.out.println(current);
                }
                else{
                    System.out.println("no previous URLs");
                }

            } else if (command.equals("forward")) {

                if(forwards.isEmpty()){
                    System.out.println("no next URLs");
                }
                else{
                    String site = forwards.poll();
                    deck.push(site);
                    System.out.println(site);
                    forwards.clear();
                }

            } else {
                forwards.clear();
                deck.push(command);
                System.out.println(command);
            }


            command = sc.nextLine();
        }


    }
}

