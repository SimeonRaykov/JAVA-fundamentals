import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> deck = new ArrayDeque<>();

        String command = sc.nextLine();
        while (!command.equals("print")) {

            if (command.equals("cancel")) {
                if(deck.size()>=1){
                    System.out.println("Canceled " + deck.poll());
                }
                else{
                    System.out.println("Printer is on standby");
                }
            }
            else{
                deck.offer(command);
            }
            command = sc.nextLine();
        }

        while(!deck.isEmpty()){
            System.out.println(deck.poll());
        }

    }
}
