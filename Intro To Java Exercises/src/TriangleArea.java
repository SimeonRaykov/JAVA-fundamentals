import java.util.Scanner;

public class TriangleArea {

    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        int Ax = Scanner.nextInt();
        int Ay = Scanner.nextInt();
        Scanner.nextLine();
        int Bx = Scanner.nextInt();
        int By = Scanner.nextInt();
        Scanner.nextLine();
        int Cx = Scanner.nextInt();
        int Cy = Scanner.nextInt();

        long area=(Ax*(By-Cy)+Bx*(Cy-Ay)+Cx*(Ay-By))/2;

        System.out.printf("%d",Math.abs(area));

    }
}
