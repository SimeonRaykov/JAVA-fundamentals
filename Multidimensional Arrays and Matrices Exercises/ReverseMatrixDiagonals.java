import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {

            String[] rowsCols = sc.nextLine().split("\\s+");
            int[][] matrix = new int[Integer.parseInt(rowsCols[0])][Integer.parseInt(rowsCols[1])];

            for (int i = 0; i < matrix.length; i++) {
                String lines[] = sc.nextLine().split(" ");
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = Integer.parseInt(lines[j]);
                }
            }

            int row = Integer.parseInt(rowsCols[0]) - 1;
            int col = Integer.parseInt(rowsCols[1]) - 1;

            int i = 0;
            int m = 0;
            int counter = 0;

            while (col >= 0) {
                System.out.print(matrix[row][col] + " ");
                i = row;
                m = col;
                while (row - 1 >= 0 && col + 1 < matrix[0].length) {

                    row -= 1;
                    col += 1;
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
                if (counter != 0) {
                    row = i;
                    col = m;
                }
                counter += 1;
                col -= 1;
            }
            if (matrix.length != 1) {
                col = 0;
                row -= 1;

                i = 0;
                m = 0;
                while (row >= 0) {
                    System.out.print(matrix[row][col] + " ");
                    i = row;
                    m = col;
                    while (row - 1 >= 0 && col + 1 <= matrix[0].length) {
                        row -= 1;
                        col += 1;
                        System.out.print(matrix[row][col] + " ");
                    }
                    row = i;
                    col = m;
                    row -= 1;
                    System.out.println();
                }
            }
        }
        catch (Exception e){

        }
    }
}
