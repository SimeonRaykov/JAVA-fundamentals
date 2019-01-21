import java.util.Scanner;
import java.util.Arrays;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        String[][] matrix = new String[nums[0]][nums[1]];

        for (int i = 0; i < nums[0]; i++) {
            for (int j = 0; j < nums[1]; j++) {
                String currentElement = "" + (char)('a'+ i) + (char)('a' + i + j) +(char)('a'+ i) ;
                matrix[i][j] = currentElement;
            }
        }
        printMatrix(matrix);
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
