import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\havit\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\havit\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(inputPath);
            out = new FileOutputStream(outputPath);

            int byteData = in.read();
            while (byteData >= 0) {

                if (byteData == ' ' || byteData == '\n') {
                    out.write(byteData);
                } else {
                    String str = String.valueOf(byteData);
                    for (int i = 0; i < str.length(); i++) {
                        out.write(str.charAt(i));
                    }
                }
                byteData = in.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println("fail");
            }
        }

    }
}
