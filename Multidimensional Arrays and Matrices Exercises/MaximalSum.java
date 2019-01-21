import java.util.Scanner;
import java.util.Arrays;

public class MaximalSUm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int[][] matrix = new int[nums[0]][nums[1]];
        int maxValueSubmatrix = Integer.MIN_VALUE;
        int[][] subMatrix = new int[3][3];
        int rowSubIndex = 0;
        int colSubIndex = 0;

        for (int i = 0; i < nums[0]; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < nums[1]; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < nums[0] - 2; i++) {
            for (int j = 0; j < nums[1] - 2; j++) {
                int firstNumber = matrix[i][j];
                if (sumSubmatrix(i, j, matrix) > maxValueSubmatrix) {
                    maxValueSubmatrix = sumSubmatrix(i,j,matrix);
                    rowSubIndex = i;
                    colSubIndex = j;
                }
            }
        }
        printSubmatrix(rowSubIndex, colSubIndex, matrix);
        //  System.out.println(sumSubmatrix(rowSubIndex,colSubIndex,matrix));
    }

    private static int sumSubmatrix(int row, int col, int[][] matrix) {
        int sum = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static void printSubmatrix(int row, int col, int[][] matrix) {
        System.out.println("Sum = "+sumSubmatrix(row, col, matrix));

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
