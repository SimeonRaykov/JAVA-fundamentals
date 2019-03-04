package AshesOfRoses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Region> rosesMap = new TreeMap<>();

        String command = bf.readLine();
        while (!command.equals("Icarus, Ignite!")) {

            if (isValid(command)) {
                String tokens[] = command.split("[< >]|\\s+");

                List<String> list = new ArrayList<String>(Arrays.asList(tokens));
                list.removeAll(Arrays.asList("", null));

                if (list.get(0).equals("Grow")) {
                    try {
                        if (!rosesMap.containsKey(list.get(1))) {
                            Region region = new Region(list.get(1));
                            rosesMap.put(list.get(1), region);
                            Rose rose = new Rose(list.get(2), Integer.parseInt(list.get(3)));
                            rosesMap.get(list.get(1)).addRose(rose);

                        } else if (rosesMap.get(list.get(1)).containsRose(list.get(2))) {
                            rosesMap.get(list.get(1)).getRose(list.get(2)).increaseRosesCount(Integer.parseInt(list.get(3)));

                        } else if (!rosesMap.get(list.get(1)).containsRose(list.get(2))) {
                            Rose rose = new Rose(list.get(2), Integer.parseInt(list.get(3)));
                            rosesMap.get(list.get(1)).addRose(rose);
                        }

                    } catch (Exception e) {
                        command = bf.readLine();
                        continue;
                    }
                }
            }
                command = bf.readLine();
        }


        List<Region> sortedRegions = rosesMap.values()
                .stream().sorted(Comparator.comparingInt(Region::getRosesCount)
                        .reversed()
                        .thenComparing(Region::getName))
                .collect(Collectors.toList());

        for (Region sortedRegion : sortedRegions) {
            System.out.println(sortedRegion.toString());
            final List<Rose> sortedRoses = sortedRegion.getRoses()
                    .stream().sorted(Comparator.comparingInt(Rose::getCount)
                            .thenComparing(Rose::getName))
                    .collect(Collectors.toList());

            for (Rose sortedRose : sortedRoses) {
                System.out.println(sortedRose.toString());
            }

        }

    }

    private static boolean isValid(String str) {
        boolean state = true;
        int x = 0;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                x += 1;
            }
        }
        state = x <= 3;
        return state;
    }
}
