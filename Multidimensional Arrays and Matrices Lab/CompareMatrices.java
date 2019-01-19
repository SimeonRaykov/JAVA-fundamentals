import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] firstRowCol = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[][] matrixFirst = new int[firstRowCol[0]][firstRowCol[1]];

        for (int i = 0; i < firstRowCol[0]; i++) {
            String[] firstLines = sc.nextLine().split(" ");
            for (int j = 0; j < firstRowCol[1]; j++) {
                matrixFirst[i][j] = Integer.parseInt(firstLines[j]);
            }
        }
        int[] secondRowCol = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[][] matrixSecond = new int[secondRowCol[0]][secondRowCol[1]];

        for (int i = 0; i < secondRowCol[0]; i++) {
            String[] firstLines = sc.nextLine().split(" ");
            for (int j = 0; j < secondRowCol[1]; j++) {
                matrixSecond[i][j] = Integer.parseInt(firstLines[j]);
            }
        }
        if (firstRowCol[0] != secondRowCol[0] || firstRowCol[1] != secondRowCol[1]) {
            System.out.println("not equal");
            return;
        }

        for (int i = 0; i < firstRowCol[0]; i++) {
            for (int j = 0; j < firstRowCol[1]; j++) {
                if (matrixFirst[i][j] != matrixSecond[i][j]) {
                    System.out.println("not equal");
                    return;
                }

            }
        }
        System.out.println("equal");


    }
}
