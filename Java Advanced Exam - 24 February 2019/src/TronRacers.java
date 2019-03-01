import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TronRacers {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int rowsCols = Integer.parseInt(bf.readLine());

        String matrix[][] = new String[rowsCols][rowsCols];

        int[] playerFposition = new int[2];
        int[] playerSposition = new int[2];

        for (int i = 0; i < matrix.length; i++) {
            String[] tokens = bf.readLine().split("");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = tokens[j];
                if (tokens[j].equals("f")) {
                    playerFposition[0] = i;
                    playerFposition[1] = j;
                } else if (tokens[j].equals("s")) {
                    playerSposition[0] = i;
                    playerSposition[1] = j;
                }
            }
        }

        boolean sPlayerWon = false;
        boolean fPlayerWon = false;

        while (!sPlayerWon && !fPlayerWon) {
            String playerMovements[] = bf.readLine().split("\\s+");

            String playerFmovement = playerMovements[0];
            String playerSmovement = playerMovements[1];

            MoveFirstPlayer moveFirstPlayer = new MoveFirstPlayer(matrix, playerFposition, sPlayerWon, playerFmovement).invoke();
            if (moveFirstPlayer.is()) break;
            sPlayerWon = moveFirstPlayer.issPlayerWon();


            MoveSecondPlayer moveSecondPlayer = new MoveSecondPlayer(matrix, playerSposition, fPlayerWon, playerSmovement).invoke();
            if (moveSecondPlayer.is()) break;
            fPlayerWon = moveSecondPlayer.isfPlayerWon();

        }


        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] );
            }
            System.out.println();
        }
    }

    private static class MoveFirstPlayer {
        private boolean myResult;
        private String[][] matrix;
        private int[] playerFposition;
        private boolean sPlayerWon;
        private String playerFmovement;

        public MoveFirstPlayer(String[][] matrix, int[] playerFposition, boolean sPlayerWon, String playerFmovement) {
            this.matrix = matrix;
            this.playerFposition = playerFposition;
            this.sPlayerWon = sPlayerWon;
            this.playerFmovement = playerFmovement;
        }

        boolean is() {
            return myResult;
        }

        public boolean issPlayerWon() {
            return sPlayerWon;
        }

        public MoveFirstPlayer invoke() {
            if (playerFmovement.equals("down")) {
                if (playerFposition[0] + 1 >= matrix.length) {
                    playerFposition[0] = 0;
                    matrix[playerFposition[0]][playerFposition[1]]  = "f";
                } else if (matrix[playerFposition[0] + 1][playerFposition[1]].equals("*")) {
                    matrix[playerFposition[0] + 1][playerFposition[1]] = "f";
                    playerFposition[0] += 1;
                } else if (matrix[playerFposition[0] + 1][playerFposition[1]].equals("f")) {
                    playerFposition[0] += 1;
                } else if (matrix[playerFposition[0] + 1][playerFposition[1]].equals("s")) {
                    matrix[playerFposition[0] + 1][playerFposition[1]] = "x";
                    playerFposition[0] += 1;
                    sPlayerWon = true;
                    myResult = true;
                    return this;
                }

            } else if (playerFmovement.equals("up")) {

                if (playerFposition[0] - 1 < 0) {
                    playerFposition[0] = matrix.length - 1;
                    matrix[playerFposition[0]][playerFposition[1]]  = "f";
                } else if (matrix[playerFposition[0] - 1][playerFposition[1]].equals("*")) {
                    matrix[playerFposition[0] - 1][playerFposition[1]] = "f";
                    playerFposition[0] -= 1;
                } else if (matrix[playerFposition[0] - 1][playerFposition[1]].equals("f")) {
                    playerFposition[0] -= 1;
                } else if (matrix[playerFposition[0] - 1][playerFposition[1]].equals("s")) {
                    matrix[playerFposition[0] - 1][playerFposition[1]] = "x";
                    playerFposition[0] -= 1;
                    sPlayerWon = true;
                    myResult = true;
                    return this;
                }

            } else if (playerFmovement.equals("right")) {

                if (playerFposition[1] + 1 >= matrix.length) {
                    playerFposition[1] = 0;
                    matrix[playerFposition[0]][playerFposition[1]]  = "f";
                } else if (matrix[playerFposition[0]][playerFposition[1] + 1].equals("*")) {
                    matrix[playerFposition[0]][playerFposition[1] + 1] = "f";
                    playerFposition[1] += 1;
                } else if (matrix[playerFposition[0]][playerFposition[1] + 1].equals("f")) {
                    playerFposition[1] += 1;
                } else if (matrix[playerFposition[0]][playerFposition[1] + 1].equals("s")) {
                    matrix[playerFposition[0]][playerFposition[1] + 1] = "x";
                    playerFposition[1] += 1;
                    sPlayerWon = true;
                    myResult = true;
                    return this;
                }


            } else if (playerFmovement.equals("left")) {

                if (playerFposition[1] - 1 < 0) {
                    playerFposition[1] = matrix.length - 1;
                    matrix[playerFposition[0]][playerFposition[1]]  = "f";
                    matrix[playerFposition[0]][playerFposition[1]] = "f";
                } else if (matrix[playerFposition[0]][playerFposition[1] - 1].equals("*")) {
                    matrix[playerFposition[0]][playerFposition[1] - 1] = "f";
                    playerFposition[1] -= 1;
                } else if (matrix[playerFposition[0]][playerFposition[1] - 1].equals("f")) {
                    playerFposition[1] -= 1;
                } else if (matrix[playerFposition[0]][playerFposition[1] - 1].equals("s")) {
                    matrix[playerFposition[0]][playerFposition[1] - 1] = "x";
                    playerFposition[1] -= 1;
                    sPlayerWon = true;
                    myResult = true;
                    return this;
                }
            }
            myResult = false;
            return this;
        }
    }

    private static class MoveSecondPlayer {
        private boolean myResult;
        private String[][] matrix;
        private int[] playerSposition;
        private boolean fPlayerWon;
        private String playerSmovement;

        public MoveSecondPlayer(String[][] matrix, int[] playerSposition, boolean fPlayerWon, String playerSmovement) {
            this.matrix = matrix;
            this.playerSposition = playerSposition;
            this.fPlayerWon = fPlayerWon;
            this.playerSmovement = playerSmovement;
        }

        boolean is() {
            return myResult;
        }

        public boolean isfPlayerWon() {
            return fPlayerWon;
        }

        public MoveSecondPlayer invoke() {
            if (playerSmovement.equals("down")) {

                if (playerSposition[0] + 1 >= matrix.length) {
                    playerSposition[0] = 0;
                    matrix[playerSposition[0]][playerSposition[1]] = "s";
                } else if (matrix[playerSposition[0] + 1][playerSposition[1]].equals("*")) {
                    matrix[playerSposition[0] + 1][playerSposition[1]] = "s";
                    playerSposition[0] += 1;
                } else if (matrix[playerSposition[0] + 1][playerSposition[1]].equals("s")) {
                    playerSposition[0] += 1;
                } else if (matrix[playerSposition[0] + 1][playerSposition[1]].equals("f")) {
                    matrix[playerSposition[0] + 1][playerSposition[1]] = "x";
                    playerSposition[0] += 1;
                    fPlayerWon = true;
                    myResult = true;
                    return this;
                }

            } else if (playerSmovement.equals("up")) {

                if (playerSposition[0] - 1 < 0) {
                    playerSposition[0] = matrix.length - 1;
                    matrix[playerSposition[0]][playerSposition[1]] = "s";
                } else if (matrix[playerSposition[0] - 1][playerSposition[1]].equals("*")) {
                    matrix[playerSposition[0] - 1][playerSposition[1]] = "s";
                    playerSposition[0] -= 1;
                } else if (matrix[playerSposition[0] - 1][playerSposition[1]].equals("s")) {
                    playerSposition[0] -= 1;
                } else if (matrix[playerSposition[0] - 1][playerSposition[1]].equals("f")) {
                    matrix[playerSposition[0] - 1][playerSposition[1]] = "x";
                    playerSposition[0] -= 1;
                    fPlayerWon = true;
                    myResult = true;
                    return this;
                }

            } else if (playerSmovement.equals("right")) {

                if (playerSposition[1] + 1 >= matrix.length) {
                    playerSposition[1] = 0;
                    matrix[playerSposition[0]][playerSposition[1]] = "s";
                } else if (matrix[playerSposition[0]][playerSposition[1] + 1].equals("*")) {
                    matrix[playerSposition[0]][playerSposition[1] + 1] = "s";
                    playerSposition[1] += 1;
                } else if (matrix[playerSposition[0]][playerSposition[1] + 1].equals("s")) {
                    playerSposition[1] += 1;
                } else if (matrix[playerSposition[0]][playerSposition[1] + 1].equals("f")) {
                    matrix[playerSposition[0]][playerSposition[1] + 1] = "x";
                    playerSposition[1] += 1;
                    fPlayerWon = true;
                    myResult = true;
                    return this;
                }

            } else if (playerSmovement.equals("left")) {

                if (playerSposition[1] - 1 < 0) {
                    playerSposition[1] = matrix.length - 1;
                    matrix[playerSposition[0]][playerSposition[1]] = "s";
                } else if (matrix[playerSposition[0]][playerSposition[1] - 1].equals("*")) {
                    matrix[playerSposition[0]][playerSposition[1] - 1] = "s";
                    playerSposition[1] -= 1;
                } else if (matrix[playerSposition[0]][playerSposition[1] - 1].equals("s")) {
                    playerSposition[1] -= 1;
                } else if (matrix[playerSposition[0]][playerSposition[1] - 1].equals("f")) {
                    matrix[playerSposition[0]][playerSposition[1] - 1] = "x";
                    playerSposition[1] -= 1;
                    fPlayerWon = true;
                    myResult = true;
                    return this;
                }
            }
            myResult = false;
            return this;
        }
    }
}
