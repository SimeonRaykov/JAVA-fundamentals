import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());

        String[]linex = sc.nextLine().split(" ");

        int[][] matrix = new int[rows][linex.length];
        int[][] resultMatrix = new int[rows][linex.length];

        for (int i = 0; i <1 ; i++) {
            for (int j = 0; j <linex.length; j++) {
                matrix[i][j] = Integer.parseInt(linex[j]);
                resultMatrix[i][j] = Integer.parseInt(linex[j]);
            }
        }

        for (int i = 1; i < rows; i++) {
            String[] lines = sc.nextLine().split(" ");
            for (int j = 0; j < lines.length; j++) {
                matrix[i][j] = Integer.parseInt(lines[j]);
                resultMatrix[i][j] = Integer.parseInt(lines[j]);
            }
        }
        int[] wrongValue = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
              int currSum = 0;
                    if ((wrongValue[0] == i && wrongValue[1] == j) || matrix[i][j]==matrix[wrongValue[0]][wrongValue[1]] ) {

                    // Left
                    if (j > 0) {
                        if (matrix[i][j] != matrix[i][j - 1]) {
                            currSum += matrix[i][j - 1];
                        }
                    }
                    // Right
                    if (j+1 < matrix[0].length) {
                        if (matrix[i][j] != matrix[i][j + 1]) {
                            currSum += matrix[i][j + 1];
                        }
                    }
                    // Top
                    if (i > 0) {
                        if (matrix[i][j] != matrix[i - 1][j]) {
                            currSum += matrix[i - 1][j];
                        }
                    }
                    // Bot
                    if (i < matrix[0].length - 1 && i+1!=rows) {
                        if (matrix[i][j] != matrix[i + 1][j]) {
                            currSum += matrix[i + 1][j];
                        }
                    }
                    resultMatrix[i][j] = currSum;

                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
