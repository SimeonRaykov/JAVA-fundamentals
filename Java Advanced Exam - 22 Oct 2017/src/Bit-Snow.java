import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = bf.readLine().split(", ");
        String[][] matrix = new String[tokens.length][];
        String longest = Arrays
                .stream(tokens)
                .max(Comparator.comparingInt(String::length))
                .get();
        String biggestBinary = Integer.toBinaryString(Integer.parseInt(longest));
        int length = biggestBinary.length();

        for (int i = 0; i < tokens.length; i++) {
            StringBuilder currentRow = new StringBuilder(Integer.toBinaryString(Integer.parseInt(tokens[i])));
            while (currentRow.length() != length) {
                currentRow.insert(0, "0");
            }
            matrix[i] = currentRow.toString().split("");
        }

        boolean isMoved = true;
        while (isMoved) {
            isMoved = false;
            for (int i = 0; i < matrix.length - 1; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i + 1][j].equals("0") && matrix[i][j].equals("1")) {
                        matrix[i + 1][j] = "1";
                        matrix[i][j] = "0";
                        isMoved = true;
                    }
                }
            }
        }

        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        for (String[] aMatrix : matrix) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                row.append(aMatrix[j]);
            }
            strings.add(row.toString());
        }

        for (String string : strings) {
            String stringX = string.replaceFirst("^0*", "");
            try {
                integers.add(Integer.parseInt(stringX, 2));
            } catch (Exception e) {
                integers.add(0);
            }
        }
        int i = 0;
        for (Integer integer : integers) {
            if (i == integers.size() - 1) {
                System.out.print(integer);
            } else {
                System.out.print(integer + ", ");
            }
            i += 1;
        }

    }
}
