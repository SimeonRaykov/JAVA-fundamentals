import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeTwoFiles {
    public static void main(String[] args) {

        PrintWriter writer = null;
        BufferedReader reader = null;

        String inPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inPath2 = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\mergedFile.txt";

        try {
            reader = Files.newBufferedReader(Paths.get(inPath));
            writer = new PrintWriter(outPath);
            String line = reader.readLine();
            while (line != null) {
                writer.write(line + System.lineSeparator());
                line = reader.readLine();
            }
            reader = Files.newBufferedReader(Paths.get(inPath2));

            String secondLine = reader.readLine();
            while (secondLine != null) {
                writer.write(secondLine + System.lineSeparator());
                secondLine = reader.readLine();
            }
            writer.flush();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            writer.close();
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Fail");
            }
        }


    }
}
