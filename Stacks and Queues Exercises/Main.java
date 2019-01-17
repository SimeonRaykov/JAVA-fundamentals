import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        while (!line.equals("Home")) {

            if (line.equals("back")) {

            } else {
                System.out.println(line);
            }


            line = sc.nextLine();
        }


    }
}
