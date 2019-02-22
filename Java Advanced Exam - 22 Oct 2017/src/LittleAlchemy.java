import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> intList = Arrays.stream(bf.readLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayList<Integer> goldPieces = new ArrayList<>();

        String command = bf.readLine();

        while (!command.equalsIgnoreCase("Revision")) {

            String[] tokens = command.split("\\s+");

            if (tokens[0].equals("Apply") && tokens[1].equals("acid")) {

                if (intList.size() == 0) {
                    command = bf.readLine();
                    continue;
                }
                try {
                    for (int i = 0; i < Integer.parseInt(tokens[2]); i++) {
                        if (intList.get(0) == 1) {
                            goldPieces.add(0);
                            intList.remove(0);
                        } else {
                            int currNum = intList.get(0);
                            currNum -= 1;
                            intList.remove(0);
                            intList.add(currNum);
                        }
                    }
                } catch (Exception e) {

                }

            } else if (tokens[0].equals("Air") && tokens[1].equals("leak")) {
                if (goldPieces.size() == 0) {
                    command = bf.readLine();
                    continue;
                } else {
                    int num = Integer.parseInt(tokens[2]);
                    goldPieces.remove(0);
                    intList.add(num);
                }
            }

            command = bf.readLine();
        }

        for (Integer integer : intList) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println(goldPieces.size());

    }
}
