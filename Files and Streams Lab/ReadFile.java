import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {

        String path = "C:\\input.txt";
        try {
            InputStream fileStream = new FileInputStream(path);
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte)+" ");
                oneByte = fileStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
