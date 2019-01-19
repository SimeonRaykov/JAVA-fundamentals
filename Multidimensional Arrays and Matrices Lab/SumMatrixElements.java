import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsCols = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::valueOf).toArray();
        int[][] matrix = new int[rowsCols[0]][rowsCols[1]];

        int sum = 0;
        for (int i = 0; i < rowsCols[0]; i++) {
            String[] line = sc.nextLine().split(", ");
            for (int j = 0; j < rowsCols[1]; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
                sum+= matrix[i][j];
            }
        }
        System.out.println(rowsCols[0]);
        System.out.println(rowsCols[1]);
        System.out.println(sum);


    }
}
