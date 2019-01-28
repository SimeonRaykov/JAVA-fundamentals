import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        PrintWriter writer = null;
        BufferedReader reader = null;

        String inPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String inPath2 = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String writePath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\wordsCount.txt";

        HashMap<String, Integer> unsortedMap = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        try {
            reader = Files.newBufferedReader(Paths.get(inPath));
            writer = new PrintWriter(writePath);

            String line = reader.readLine();
            while (line != null) {
                String[] lineX = line.split(" ");
                for (int i = 0; i < lineX.length; i++) {
                    set.add(lineX[i]);
                }

                line = reader.readLine();
            }
            reader = Files.newBufferedReader(Paths.get(inPath2));
            line = reader.readLine();

            while (line != null) {
                String[] tokens = line.split("\\s+");
                for (int i = 0; i < tokens.length; i++) {

                    if (set.contains(tokens[i])) {
                        if (!unsortedMap.containsKey(tokens[i])) {
                            unsortedMap.put(tokens[i], 1);
                        } else {
                            unsortedMap.put(tokens[i], unsortedMap.get(tokens[i]) + 1);
                        }
                    }
                }
                line = reader.readLine();
            }

            Map<String, Integer> newMap = new TreeMap(Collections.reverseOrder());
            newMap.putAll(unsortedMap);
            for (String s : newMap.keySet()) {
                writer.write(s + " - " + newMap.get(s) + System.lineSeparator());
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
