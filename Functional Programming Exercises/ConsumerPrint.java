import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner Scanner=new Scanner(System.in);
        String []line = Scanner.nextLine().split("\\s+");
        Consumer<String> c = System.out::println;
        for (String s : line) {
            c.accept(s);
        }

    }
}
