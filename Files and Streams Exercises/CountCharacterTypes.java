import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CountCharacterTypes {
    public static void main(String[] args) {

        PrintWriter writer = null;
        BufferedReader reader = null;

        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        ArrayList<Character> consonants = new ArrayList<>();
        ArrayList<Character> punctuation = new ArrayList<>(Arrays.asList('!', '?', ',', '.'));

        String inPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outPath = "C:\\Users\\Simeon\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\countCharacterTypes.txt";
        try {
            reader = Files.newBufferedReader(Paths.get(inPath));
            writer = new PrintWriter(outPath);

            String line = reader.readLine();
            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (c != ' ') {
                        if (punctuation.contains(c)) {
                            punctuation.add(c);
                        } else if (vowels.contains(c)) {
                            vowels.add(c);
                        } else {
                            consonants.add(c);
                        }
                    }
                }
                line = reader.readLine();
            }
            writer.write("Vowels: "+(vowels.size()-5)+System.lineSeparator());
            writer.write("Consonants: "+(consonants.size())+System.lineSeparator());
            writer.write("Punctuation: "+(punctuation.size()-4)+System.lineSeparator());

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
