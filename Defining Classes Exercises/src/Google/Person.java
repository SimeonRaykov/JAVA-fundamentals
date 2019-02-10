package Google;

import java.util.ArrayList;

public class Person {

    private String name;
    private Company company;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Parents> parents;
    private ArrayList<Children> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.company = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = null;
    }

    public void addChild(Children child) {
        this.children.add(child);
    }

    public void addParent(Parents parent) {
        this.parents.add(parent);
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public ArrayList<Parents> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Parents> parents) {
        this.parents = parents;
    }

    public ArrayList<Children> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Children> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(System.lineSeparator())
                .append("Company: ").append(System.lineSeparator());
        if (getCompany() != null) {
            sb.append(getCompany().toString()).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (getCar() != null) {
            sb.append(getCar().toString());
        }
        sb.append(System.lineSeparator());
        sb.append("Pokemon:").append(System.lineSeparator());
        if (getPokemons() != null) {
            for (Pokemon pokemon : pokemons) {
                sb.append(pokemon.toString());
                sb.append(System.lineSeparator());
            }
        } else {
            sb.append(System.lineSeparator());
        }
        sb.append("Parents:").append(System.lineSeparator());
        if (getParents() != null) {
            for (Parents parent : parents) {
                sb.append(parent.toString());
                sb.append(System.lineSeparator());
            }
        } else {
            sb.append(System.lineSeparator());
        }
        sb.append("Children:").append(System.lineSeparator());
        if (getChildren() != null) {
            for (Children child : children) {
                sb.append(child.toString());
            }
        }
        return sb.toString();
    }
}
