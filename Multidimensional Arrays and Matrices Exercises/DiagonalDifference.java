import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        if(rows == 1){
            System.out.println(1);
        }
        int[][] matrix = new int[rows][rows];

        for (int i = 0; i < rows; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < rows; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        int leftSum = 0;
        int rightSum = 0;

        int row = 0;
        int col = 0;

        while (col<rows && row<rows){
            int element = matrix[row][col];
            leftSum+=element;
            row+=1;
            col+=1;
        }
        row = rows - 1;
        col = 0;

        while (col<rows && row<rows){
            int element = matrix[row][col];
            rightSum+=element;
            row-=1;
            col+=1;
        }
        System.out.println(Math.abs(leftSum - rightSum));
    }
}
