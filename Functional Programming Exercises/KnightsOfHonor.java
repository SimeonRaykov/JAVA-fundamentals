import java.util.Scanner;
        import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner Scanner=new Scanner(System.in);
        String []line = Scanner.nextLine().split("\\s+");
        Consumer<String> c =(x)->System.out.println("Sir "+x);
        for (String s : line) {
            c.accept(s);
        }
    }
}
