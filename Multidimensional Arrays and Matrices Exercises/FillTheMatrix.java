import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");
        //   int[][] matrix = new int[Integer.parseInt(input[1])][Integer.parseInt(input[1])];

        if (input[1].equals("A")) {
            fillMatrixWithPatternA(Integer.parseInt(input[0]));
        } else {
            fillMatrixWithPatternB(Integer.parseInt(input[0]));
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void fillMatrixWithPatternA(int num) {

        int[][] matrix = new int[num][num];
        int value = 1;
        for (int col = 0; col < num; col++) {
            for (int row = 0; row < num; row++) {
                matrix[row][col] = value;
                value += 1;
            }
        }
        printMatrix(matrix);
    }

    private static void fillMatrixWithPatternB(int num) {

        int[][] matrix = new int[num][num];
        int value = 1;
        for (int col = 0; col < num; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < num; row++) {
                    matrix[row][col] = value;
                    value += 1;
                }
                //     value +=num - 1;
            } else {
                for (int row = num - 1 ; row>= 0; row--) {
                    matrix[row][col] = value;
                    value += 1;
                }


            }
            //     for (int row = 0; row < num; row++) {
            //         matrix[row][col] = value;
            //         value -= 1;
            //     }
            // value += num + 1;
        }

        printMatrix(matrix);
    }
}
