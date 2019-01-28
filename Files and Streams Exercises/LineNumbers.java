import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {

        PrintWriter writer = null;
        BufferedReader reader = null;

        String inPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\lineNumbers.txt";
        try {
            reader = Files.newBufferedReader(Paths.get(inPath));
            writer = new PrintWriter(outPath);

            String line = reader.readLine();
            int count = 1;
            while (line != null) {
                writer.write(count + ". " + line+System.lineSeparator());
                line = reader.readLine();
                count += 1;
            }
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
