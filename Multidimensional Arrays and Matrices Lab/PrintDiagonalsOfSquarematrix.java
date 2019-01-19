import java.util.Scanner;

public class PrintDiagonalsOfSquarematrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String leftDiagonal = "";
        String rightDiagonal = "";

        int[][] squareMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] lines = sc.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                squareMatrix[i][j] = Integer.parseInt(lines[j]);
            }
        }
        int row = 0;
        int col = 0;
        //Moving bottom right
        while (row < n && col < n) {
            leftDiagonal += squareMatrix[row][col] + " ";
            row += 1;
            col += 1;
        }
        //Moving top right
        row = n - 1;
        col = 0;
        while (row + 1 > 0 && col < n) {
            rightDiagonal += squareMatrix[row][col] + " ";
            row -= 1;
            col += 1;
        }

        System.out.println(leftDiagonal);
        System.out.println(rightDiagonal);

    }
}
