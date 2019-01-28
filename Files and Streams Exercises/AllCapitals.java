import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main(String[] args) {

        PrintWriter writer = null;
        BufferedReader reader = null;

        String inPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\allCapitals.txt";
        try {
            reader = Files.newBufferedReader(Paths.get(inPath));
            writer = new PrintWriter(outPath);

            String line = reader.readLine();
            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (c != ' ') {
                        writer.write(Character.toUpperCase(c));
                    }
                    else{
                        writer.write(c);
                    }
                }
                writer.write(System.lineSeparator());

                line = reader.readLine();
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
