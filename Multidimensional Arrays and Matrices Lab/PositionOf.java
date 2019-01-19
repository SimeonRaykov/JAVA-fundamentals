import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int[] rowsCols = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int[][] matrix = new int[rowsCols[0]][rowsCols[1]];

        for (int i = 0; i < rowsCols[0]; i++) {
            String[] line = sc.nextLine().split("\\s+");
            for (int j = 0; j < rowsCols[1]; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        int searchedNumber = sc.nextInt();
     //   boolean isFound = false;

        ArrayDeque<String> deck = new ArrayDeque<>();

        for (int i = 0; i < rowsCols[0]; i++) {
            for (int j = 0; j < rowsCols[1]; j++) {
                if (matrix[i][j] == searchedNumber) {
                   // System.out.println(i + " " + j);
                   // isFound = true;
                     deck.offer(i+" "+j);
                }
            }
        }
        // if(!isFound){
        //     System.out.println("not found");
        //  }
        if (deck.isEmpty()) {
            System.out.println("not found");
        } else {
            while (!deck.isEmpty()) {
                System.out.println(deck.poll());
            }
        }

    }
}
