package LegendaryFarming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> junkItems = new TreeMap<>();
        HashMap<String, KeyMaterial> keyMaterials = new HashMap<>();
        boolean isShadowmourne = false;
        boolean isValanyr = false;
        boolean isDragonwrath = false;

        while (!isDragonwrath && !isShadowmourne && !isValanyr) {
            String[] tokens = bf.readLine().split("\\s+");

            for (int i = 0; i < tokens.length; i += 2) {
                if (isDragonwrath || isValanyr || isShadowmourne) {
                    break;
                }
                String name = tokens[i + 1];
                int currQuantity = Integer.parseInt(tokens[i]);

                if (name.equalsIgnoreCase("motes")
                        || name.equalsIgnoreCase("shards")
                        || name.equalsIgnoreCase("fragments")) {
                    if (!keyMaterials.containsKey(name)) {
                        KeyMaterial keyMaterial = new KeyMaterial(name, currQuantity);
                        keyMaterials.put(name, keyMaterial);
                    } else {
                        keyMaterials.get(name).incrementQuantity(currQuantity);
                    }
                } else {
                    if (!junkItems.containsKey(name)) {
                        junkItems.put(name, currQuantity);
                    } else {
                        junkItems.put(name, junkItems.get(name) + currQuantity);
                    }
                }
                for (KeyMaterial keyMaterial : keyMaterials.values()) {
                    if (keyMaterial.checkIfItsLegendary()) {
                        if (keyMaterial.getName().equalsIgnoreCase("motes")) {
                            isDragonwrath = true;
                            keyMaterial.removeLegendQuantity();
                            break;
                        } else if (keyMaterial.getName().equalsIgnoreCase("fragments")) {
                            isValanyr = true;
                            keyMaterial.removeLegendQuantity();
                            break;
                        } else if (keyMaterial.getName().equalsIgnoreCase("shards")) {
                            isShadowmourne = true;
                            keyMaterial.removeLegendQuantity();
                            break;
                        }
                    }
                }
            }

        }

        if (isDragonwrath) {
            System.out.println("Dragonwrath obtained!");
        } else if (isShadowmourne) {
            System.out.println("Shadowmourne obtained!");
        } else if (isValanyr) {
            System.out.println("Valanyr obtained!");
        }

        List<KeyMaterial> sortedKeyMaterials = keyMaterials.values().stream()
                .sorted(Comparator.comparingInt(KeyMaterial::getQuantity).reversed()
                .thenComparing((e1,e2)->e2.getName().compareTo(e1.getName())))
                .collect(Collectors.toList());

        for (KeyMaterial sortedKeyMaterial : sortedKeyMaterials) {
            System.out.println(sortedKeyMaterial.toString());
        }

        for (Map.Entry<String, Integer> junkItem : junkItems.entrySet()) {
            System.out.println(junkItem.getKey() + " " + junkItem.getValue());
        }

    }
}
