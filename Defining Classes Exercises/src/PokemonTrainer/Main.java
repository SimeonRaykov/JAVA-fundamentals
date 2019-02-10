package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        String command = bf.readLine();
        while (!command.equals("Tournament")) {

            String[] tokens = command.split("\\s+");
            Pokemon pokemon = new Pokemon(tokens[1], tokens[2], Integer.parseInt(tokens[3]));
            if (!trainers.containsKey(tokens[0])) {
                Trainer trainer = new Trainer(tokens[0]);
                trainers.putIfAbsent(tokens[0], trainer);
            }
            if (trainers.containsKey(tokens[0])) {
                trainers.get(tokens[0]).addPokemon(pokemon);
            }
            command = bf.readLine();
        }

        command = bf.readLine();
        while (!command.equals("End")) {

            for (Trainer trainer : trainers.values()) {
                if (trainer.hasElement(command)) {
                    trainer.incrementBadges();
                } else {
                    trainer.loseHealth();
                    trainer.deleteDefeatedPokemons();
                }
            }
            command = bf.readLine();
        }

        List<Trainer> sortedTrainers = trainers.values().stream()
                .sorted(Comparator.comparingInt(Trainer::getBadges)
                        .reversed())
                .collect(Collectors.toList());

        for (Trainer sortedTrainer : sortedTrainers) {
            System.out.println(sortedTrainer.toString());
        }

    }
}
