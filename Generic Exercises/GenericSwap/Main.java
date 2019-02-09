package GenericSwap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        ArrayList boxes = new ArrayList();

        for (int i = 0; i < n; i++) {

            int info = Integer.parseInt(bf.readLine());
            BoxSwap<Integer> box = new BoxSwap<>(info);
            boxes.add(box);
        }
        int[] swappingNums = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Collections.swap(boxes,swappingNums[0],swappingNums[1]);
        for (Object box : boxes) {
            System.out.println(box.toString());
        }

    }
}
