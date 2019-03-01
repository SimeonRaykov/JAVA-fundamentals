package heroRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HeroRepository {

    private ArrayList<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public void add(Hero hero) {
        this.data.add(hero);
    }

    public Hero getHeroWithHighestStrength() {
        return this.data.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getItem().getStrength(), e1.getItem().getStrength()))
                .collect(Collectors.toList())
                .get(0);
    }

    public Hero getHeroWithHighestAgility() {
        return this.data.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getItem().getAgility(), e1.getItem().getAgility()))
                .collect(Collectors.toList())
                .get(0);
    }

    public Hero getHeroWithHighestIntelligence() {
        return this.data.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getItem().getIntelligence(), e1.getItem().getIntelligence()))
                .collect(Collectors.toList())
                .get(0);
    }


    public void remove(String heroName) {
        for (Hero hero : data) {
            if (heroName.equals(hero.getName())) {
                this.data.remove(hero);
                return;
            }
        }
    }


    public int getCount() {
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Hero hero : data) {
            sb.append(hero.toString());
        }
        return sb.toString();
    }
}
