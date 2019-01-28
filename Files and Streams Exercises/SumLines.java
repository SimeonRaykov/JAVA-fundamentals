import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String inPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\sumLines.txt";

        FileReader in = null;
        FileOutputStream out = null;

        try {
            reader = Files.newBufferedReader(Paths.get(inPath));
            in = new FileReader(inPath);
            out = new FileOutputStream(outPath);

            String line = reader.readLine();
            int sum = 0;
            while (line!=null) {
                sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
                out.write(sum);

                line = reader.readLine();
            }
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
