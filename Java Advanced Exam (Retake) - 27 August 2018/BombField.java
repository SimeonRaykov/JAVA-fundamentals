import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class BombField {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bf.readLine());
        String[][] matrix = new String[size][size];
        List<String> commands = Arrays.asList(bf.readLine().split(","));

        for (int i = 0; i < matrix.length; i++) {
            String[] lines = bf.readLine().split("\\s+");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = lines[j];
            }
        }
        int i = 0;
        int iX = 0;
        int yX = 0;
        try {
            while (true) {
                String location = getLocationOfSapper(matrix);
                iX = Integer.parseInt(location.charAt(0) + "");
                yX = Integer.parseInt(location.charAt(1) + "");

                if (commands.get(i).equals("up")) {
                    if (matrix[iX - 1][yX].equals("B")) {
                        System.out.println("You found a bomb!");
                        if (getCountOfBombs(matrix) == 0) {
                            System.out.println("Congratulations! You found all bombs!");
                            return;
                        }
                        matrix[iX][yX] = "+";
                    } else if (matrix[iX - 1][yX].equals("e")) {
                        matrix[iX][yX] = "+";
                        System.out.println("END! " + getCountOfBombs(matrix) + " bombs left on the field");
                        return;
                    } else {
                        matrix[iX][yX] = "+";
                    }
                    matrix[iX - 1][yX] = "s";
                } else if (commands.get(i).equals("down")) {
                    if (matrix[iX + 1][yX].equals("B")) {
                        System.out.println("You found a bomb!");
                        if (getCountOfBombs(matrix) == 0) {
                            System.out.println("Congratulations! You found all bombs!");
                            return;
                        }
                        matrix[iX][yX] = "+";
                    } else if (matrix[iX + 1][yX].equals("e")) {
                        matrix[iX][yX] = "+";
                        System.out.println("END! " + getCountOfBombs(matrix) + " bombs left on the field");
                        return;
                    } else {
                        matrix[iX][yX] = "+";
                    }
                    matrix[iX + 1][yX] = "s";

                } else if (commands.get(i).equals("left")) {
                    if (matrix[iX][yX - 1].equals("B")) {
                        System.out.println("You found a bomb!");
                        if (getCountOfBombs(matrix) == 0) {
                            System.out.println("Congratulations! You found all bombs!");
                            return;
                        }
                        matrix[iX][yX] = "+";
                    } else if (matrix[iX][yX - 1].equals("e")) {
                        matrix[iX][yX] = "+";
                        System.out.println("END! " + getCountOfBombs(matrix) + " bombs left on the field");
                        return;
                    } else {
                        matrix[iX][yX] = "+";
                    }
                    matrix[iX][yX - 1] = "s";

                } else if (commands.get(i).equals("right")) {
                    if (matrix[iX][yX + 1].equals("B")) {
                        System.out.println("You found a bomb!");
                        if (getCountOfBombs(matrix) == 0) {
                            System.out.println("Congratulations! You found all bombs!");
                            return;
                        }
                        matrix[iX][yX] = "+";
                    } else if (matrix[iX][yX + 1].equals("e")) {
                        matrix[iX][yX] = "+";
                        System.out.println("END! " + getCountOfBombs(matrix) + " bombs left on the field");
                        return;
                    } else {
                        matrix[iX][yX] = "+";
                    }
                    matrix[iX][yX + 1] = "s";

                }
                i += 1;
            }
        } catch (Exception e) {
            if (getCountOfBombs(matrix) == 0) {
                System.out.println("Congratulations! You found all bombs");
            } else {
                System.out.println(+getCountOfBombs(matrix) + " bombs left on the field. Sapper position: " + "(" + iX + "," + yX + ")");
            }

        }
    }

    private static int getCountOfBombs(String[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("B")) {
                    count += 1;
                }
            }
        }
        return count;
    }

    private static String getLocationOfSapper(String[][] matrix) {
        String sapper = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("s")) {
                    sapper = i + "" + j;
                }
            }
        }
        return sapper;
    }
}
