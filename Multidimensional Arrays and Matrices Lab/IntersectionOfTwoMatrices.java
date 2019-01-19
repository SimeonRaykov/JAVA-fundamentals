import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());
        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String [] line = sc.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                firstMatrix[i][j] = line[j].charAt(0);
            }
        }
        for (int i = 0; i < rows; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                secondMatrix[i][j] = line[j].charAt(0);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (firstMatrix[i][j] !=secondMatrix[i][j]) {
                    firstMatrix[i][j] = '*';
                }
                System.out.print(firstMatrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
