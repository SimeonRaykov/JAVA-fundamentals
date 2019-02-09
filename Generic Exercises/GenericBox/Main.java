package GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        for (int i = 0; i <num; i++) {
            int data = Integer.parseInt(bf.readLine());
            Box<Integer> box = new Box<>(data);
            System.out.println(box.toString());
        }

    }
}
