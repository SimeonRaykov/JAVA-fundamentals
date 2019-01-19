import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] matrix = new String[8][8];
        for (int i = 0; i < 8; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = line[j];
            }
        }
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        boolean isQueen = true;

        String realQueen = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                left = j;
                right = j;
                up = i;
                down = i;
                isQueen = true;
                //Moving left
                while (left > 0) {
                    if (matrix[i][left - 1].equals("q")) {
                        isQueen = false;
                        break;
                    }
                    left -= 1;
                }
                //Moving right
                while (right < 7) {
                    if (matrix[i][right + 1].equals("q")) {
                        isQueen = false;
                        break;
                    }
                    right += 1;
                }
                //Moving upwards
                while (up > 0) {
                    if (matrix[up - 1][j].equals("q")) {
                        isQueen = false;
                        break;
                    }
                    up -= 1;
                }
                //Moving downwards
                while (down < 7) {
                    if (matrix[down + 1][j].equals("q")) {
                        isQueen = false;
                        break;
                    }
                    down += 1;
                }
                //Moving top left
                up = i;
                left = j;
                while (left > 0 && up > 0) {
                    if (matrix[up - 1][left - 1].equals("q")) {
                        isQueen = false;
                        break;
                    }
                    up -= 1;
                    left -= 1;
                }
                //Moving top right
                up = i;
                right = j;
                while (up > 0 && right < 7) {
                    if (matrix[up - 1][right + 1].equals("q")) {
                        isQueen = false;
                        break;
                    }
                    up -= 1;
                    right += 1;
                }
                //Moving bottom left
                down = i;
                left = j;
                while (down < 7 && left > 0) {
                    if (matrix[down + 1][left - 1].equals("q")) {
                        isQueen = false;
                        break;
                    }
                    down += 1;
                    left -= 1;
                }
                //Moving bottom right
                down = i;
                right = j;
                while (down < 7 && right < 7) {
                    if (matrix[down + 1][right + 1].equals("q")) {
                        isQueen = false;
                        break;
                    }
                    down += 1;
                    right += 1;
                }

                if (isQueen && matrix[i][j].equals("q")) {
                    realQueen = i + " " + j;
                 //   System.out.println(i + " " + j);
                }
            }
        }
        System.out.println(realQueen);

    }
}
