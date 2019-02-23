import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShockWave {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        final List<Integer> rowsCols = Arrays.stream(bf.readLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int matrix[][] = new int[rowsCols.get(0)][rowsCols.get(1)];

        String command = bf.readLine();
        while (!command.equals("Here We Go")) {

            List<Integer> locations = Arrays.stream(command.split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            for (int i = locations.get(0); i <= locations.get(2); i++) {
                for (int j = locations.get(1); j <= locations.get(3); j++) {
                    matrix[i][j] += 1;
                }
            }

            command = bf.readLine();
        }

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
