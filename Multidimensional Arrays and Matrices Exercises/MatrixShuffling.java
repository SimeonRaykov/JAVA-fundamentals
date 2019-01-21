import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] rowsCols = sc.nextLine().split("\\s+");
        String[][] matrix = new String[Integer.parseInt(rowsCols[0])][Integer.parseInt(rowsCols[1])];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = (sc.nextLine().split("\\s+"));
        }
        String[] command = sc.nextLine().split("\\s+");
        while (!command[0].equals("END")) {

            if (command[0].equals("swap")) {
                try {
                    String value = matrix[Integer.parseInt(command[1])][Integer.parseInt(command[2])];
                    matrix[Integer.parseInt(command[1])][Integer.parseInt(command[2])] = matrix[Integer.parseInt(command[3])][Integer.parseInt(command[4])];
                    matrix[Integer.parseInt(command[3])][Integer.parseInt(command[4])] = value;
                    printMatrix(matrix);
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                }
            }
            else{
                System.out.println("Invalid input!");
            }
            command = sc.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
