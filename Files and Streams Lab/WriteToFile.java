import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\havit\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\havit\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";
        FileInputStream in = null;
        FileOutputStream out;
        HashSet<Character> escapeChars = new HashSet<>(Arrays.asList('.', '!', '?', ','));

        try {
            in = new FileInputStream(inputPath);
            out = new FileOutputStream(outputPath);
            int byteData = in.read();
            while (byteData >= 0) {
                if (!escapeChars.contains((char) (byteData))) {
                    out.write(byteData);
                }
                byteData = in.read();
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                in.close();
            } catch (IOException e) {
                System.out.println("Program not closed");
            }
        }
    }
}
