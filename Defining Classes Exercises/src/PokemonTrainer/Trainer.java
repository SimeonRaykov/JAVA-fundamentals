package PokemonTrainer;

import java.util.ArrayList;

public class Trainer {

    private String name;
    private ArrayList<Pokemon> pokemons;
    private int badges;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.badges = 0;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void deleteDefeatedPokemons() {
        for (int i = 0; i <getPokemons().size(); i++) {

            if (pokemons.get(i).getHealth() <= 0) {
                pokemons.remove(i);
            }
        }
    }

    public void loseHealth() {
        int pokemonSize = getPokemons().size();
        for (int i = 0; i < pokemonSize; i++) {
            pokemons.get(i).loseHealth();
        }
    }

    public boolean hasElement(String element) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void incrementBadges() {
        this.badges += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ")
                .append(this.badges).append(" ")
                .append(this.pokemons.size());

        return sb.toString();
    }
}
