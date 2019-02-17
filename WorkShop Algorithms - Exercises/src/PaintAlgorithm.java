import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PaintAlgorithm {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] ints = Arrays.stream(bf.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = new String[ints[0]][ints[1]];

        for (int i = 0; i < matrix.length; i++) {
            String[] tokens = bf.readLine().split("\\s+");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = tokens[j];
            }
        }

        String fillChar = bf.readLine();
        int[] indexes = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        String colorToReplace = matrix[indexes[0]][indexes[1]];
        apply(matrix, colorToReplace, fillChar, indexes[0], indexes[1]);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    private static void apply(String[][] picture, String colorToReplace, String colorToPaint, int x, int y) {
        validatePicture(picture);
        String currentColor = "";
        try {
            currentColor = getValueAt(picture, x, y);
        } catch (Exception e) {

        }
        try {
            if (currentColor.equals(colorToReplace)) {
                picture[x][y] = colorToPaint;
                apply(picture, colorToReplace, colorToPaint, x + 1, y);
                apply(picture, colorToReplace, colorToPaint, x - 1, y);
                apply(picture, colorToReplace, colorToPaint, x, y + 1);
                apply(picture, colorToReplace, colorToPaint, x, y - 1);
            }
        }
        catch (Exception e){

        }
    }

    private static void validatePicture(String[][] picture) {
        if (picture == null) {
            throw new IllegalArgumentException("You can't pass a null instance as picture");
        }
    }

    /**
     * Method created to avoid IndexOutOfBoundExceptions. This method return -1 if you try to access
     * an invalid position.
     */
    private static String getValueAt(String[][] picture, int x, int y) {
        if (x < 0 || y < 0 || x > picture.length || y > picture[x].length) {
            return null;
        } else {
            return picture[x][y];
        }
    }
}
