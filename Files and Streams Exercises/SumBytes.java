import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String inPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\sumBytes.txt";

        PrintWriter printWriter = null;
        try {
            reader = Files.newBufferedReader(Paths.get(inPath));
            printWriter = new PrintWriter(outPath);
            String line = reader.readLine();
            int sum = 0;
            while (line != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                printWriter.write(sum);
                line = reader.readLine();
            }
            printWriter.close();
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();

            } catch (IOException e) {
                System.out.println("Program failed");
            }
        }
    }
}
